import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s1="aab";
        String s2="aab";
        String s3="a";
        if(s1==s2)
            System.out.println(s1);
        if(s3.equals(s1.substring(0,s3.length())))
            System.out.println(s1);
    }
}
