import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by SoniSSD on 17.12.2014.
 */
public class TestAutocomplite extends TestCase {
    //Количество хранимых элементов в сервисе задаем сами!
    //Не проверяю на конкретные значения, потому-что выводит случайные 10 первых попавшихся слов
    public void testAutocomplite1() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(10);
        Scanner in = new Scanner(new File("test.txt"));
        for(int i=0;i<37;i++)
        {
            a.add(in.nextLine());
        }
        ArrayList<String> strings = a.prefix("a");
        ArrayList<String> strings1=new ArrayList<String>();
        strings1.add("asadfs8");
        strings1.add("asadfs7");
        Assert.assertEquals(strings,strings1);
    }
    public void testAutocomplite2() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(50);
        Scanner in = new Scanner(new File("test.txt"));
        for(int i=0;i<37;i++)
        {
            a.add(in.nextLine());
        }
        ArrayList<String> strings = a.prefix("a");
        Assert.assertEquals(strings.size(),10);
    }
    public void testAutocomplite3() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(32);
        Scanner in = new Scanner(new File("test.txt"));
        for(int i=0;i<37;i++)
        {
            a.add(in.nextLine());
        }
        ArrayList<String> strings = a.prefix("a");
        Assert.assertEquals(strings.size(),10);
    }
    public void testAutocomplite4() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(25);
        Scanner in = new Scanner(new File("test.txt"));
        for(int i=0;i<37;i++)
        {
            a.add(in.nextLine());
        }
        ArrayList<String> strings = a.prefix("a");
        Assert.assertEquals(strings.size(),3);
    }
    public void testAutocomplite5() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(29);
        Scanner in = new Scanner(new File("test.txt"));
        for(int i=0;i<37;i++)
        {
            a.add(in.nextLine());
        }
        ArrayList<String> strings = a.prefix("a");
        Assert.assertEquals(strings.size(),7);
    }
    public void testAutocompliteBig() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(5000);
        Scanner in = new Scanner(new File("test1.txt"));
        for(int i=0;i<5146;i++)
        {
            a.add(in.nextLine());
        }
        ArrayList<String> strings = a.prefix("a");
        Assert.assertEquals(strings.size(),9);
    }
    public void testAutocompliteBig1() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(10000);
        a.add("bbe");
        a.add("bbe1");
        Integer value;
        for(Integer i=0;i<10000000;i++) {
            a.add(i.toString());
        }
        ArrayList<String> strings = a.prefix("b");
        Assert.assertEquals(strings.size(),0);
    }
    public void testAutocompliteBig2() throws FileNotFoundException {
        AutoComplite a=new AutoComplite(10000);
        a.add("bbe");
        a.add("bbe1");
        Integer value;
        for(Integer i=0;i<1000000;i++) {
            a.add(i.toString());
        }
        a.add("bbe");
        a.add("bbe1");
        ArrayList<String> strings = a.prefix("b");
        Assert.assertEquals(strings.size(),2);
    }
}
