/**
 * Created by SoniSSD on 16.11.2014.
 */
import javafx.util.Pair;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.io.FileNotFoundException;

public class TestBinaryHeap extends TestCase{
    public Random rnd=new Random();
    public void testMethodBinaryHeap1(){   //проверяем, что куча правильно добавляет, находит максимальный элемент и удаляет его
        Integer[] arr=new Integer[100];
        OrderedBinaryHeap<Integer> binaryHeap=new OrderedBinaryHeap<Integer>();
        for(int i=0;i<100;i++)
        {
            arr[i]= rnd.nextInt();
            binaryHeap.add(arr[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<100;i++)
        {
            Assert.assertEquals(arr[99-i], binaryHeap.findMax());
            Assert.assertEquals(arr[99-i], binaryHeap.deleteMax());
        }
    }
    public void testMethodBinaryHeap11(){   //проверяем, что куча правильно добавляет, находит максимальный элемент и удаляет его
        Integer[] arr=new Integer[100];
        OrderedBinaryHeap<Integer> binaryHeap=new OrderedBinaryHeap<Integer>();
        OrderedBinaryHeap<MyPair<Integer,String>> g=new OrderedBinaryHeap<MyPair<Integer, String>>();
        g.add(new MyPair<Integer, String>(2,"a"));
        g.add(new MyPair<Integer, String>(4,"b"));
        g.add(new MyPair<Integer, String>(5,"ac"));
        g.add(new MyPair<Integer, String>(1,"zad"));
        g.add(new MyPair<Integer, String>(1,"aa"));
        MyPair<Integer,String> s=new MyPair<Integer, String>(4,"b");
        for(int i=0;i<100;i++) {
            s = g.findMax();
        }
        System.out.println(s.first);
        System.out.println(s.second);
    }

    public void testMethodBinaryHeapManyElements(){   // Тоже самое, но на очень большое количество элементов
        int value=5000000;
        Integer[] arr=new Integer[value];
        OrderedBinaryHeap<Integer> binaryHeap=new OrderedBinaryHeap<Integer>();
        for(int i=0;i<value;i++)
        {
            arr[i]= rnd.nextInt();
            binaryHeap.add(arr[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<value;i++)
        {
            Assert.assertEquals(arr[value-1-i], binaryHeap.findMax());
            Assert.assertEquals(arr[value - 1 - i], binaryHeap.deleteMax());
        }
    }
    public void testMethodBinaryHeap2() throws FileNotFoundException{   //проверяем, что куча правильно добавляет, находит максимальный элемент и удаляет его
        String[] arr=new String[99];
        OrderedBinaryHeap<String> binaryHeap=new OrderedBinaryHeap<String>();
        Scanner in = new Scanner(new File("test.txt"));
        for(int i=0;i<99;i++)
        {
            arr[i]= in.nextLine();
            binaryHeap.add(arr[i]);
        }
        String[] arr1=arr.clone();
        Arrays.sort(arr);
        for(int i=0;i<99;i++)
        {
            Assert.assertEquals(arr[98-i], binaryHeap.findMax());
            binaryHeap.deleteMax();
        }
    }

}
