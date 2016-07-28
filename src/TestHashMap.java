import javafx.util.Pair;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by SoniSSD on 17.11.2014.
 */
public class TestHashMap extends TestCase{
    Random rnd = new Random();
    public void testMyHashLoad() {
        OrderedHashMap<String,Integer>  myHash = new OrderedHashMap<String,Integer> ();
        HashMap<String,Integer> map =new HashMap<String, Integer>();
        int size = 500000;
        for (int i=0;i<size;i++) {
            Integer key = (Integer) rnd.nextInt(10000);
            Integer value = (Integer) rnd.nextInt(10000);
            myHash.put(key.toString(), value);
            map.put(key.toString(), value);
            assertEquals(myHash.get(key.toString()),map.get(key.toString()));
        }
        System.out.println(myHash.get("aa"));
    }
    public void testMyHashLoad1() {
        OrderedHashMap<String,Integer>  myHash = new OrderedHashMap<String,Integer> (100000);
        HashMap<String,Integer> map =new HashMap<String, Integer>();
        int size = 5000000;
        for (int i=0;i<size;i++) {
            Integer key = (Integer) rnd.nextInt(100000);
            Integer value = (Integer) rnd.nextInt(100000);
            myHash.put(key.toString(), value);
            map.put(key.toString(), value);
            assertEquals(myHash.get(key.toString()),map.get(key.toString()));
        }
        assertEquals(myHash.size1(),100000);
    }

    public void testMyHash() {
        OrderedHashMap<String,Integer>  myHash = new OrderedHashMap<String,Integer> ();
        HashMap<String,Integer> map =new HashMap<String, Integer>();
        int size = 5000000;
        for (int i=0;i<size;i++) {
            Integer key = (Integer) rnd.nextInt(10000);
            Integer value = (Integer) rnd.nextInt(10000);
            myHash.put(key.toString(), value);
            map.put(key.toString(), value);
            assertEquals(myHash.get(key.toString()),map.get(key.toString()));
            assertEquals(myHash.remove(key.toString()),map.remove(key.toString()));
        }
    }
    public void testMyHashDeleteElements() {
        OrderedHashMap<String,Integer>  myHash = new OrderedHashMap<String,Integer> (10000);
        HashMap<String,Integer> map =new HashMap<String, Integer>();
        int size = 5000000;
        for (int i=0;i<size;i++) {
            Integer key = (Integer) rnd.nextInt(10000);
            Integer value = (Integer) rnd.nextInt(10000);
            myHash.put(key.toString(), value);
            map.put(key.toString(), value);
        }
        for (int i=0;i<size;i++) {
            Integer key = (Integer) rnd.nextInt(10000);
            Integer value = (Integer) rnd.nextInt(10000);
            assertEquals(myHash.remove(key.toString()), map.remove(key.toString()));
        }
        assertEquals(myHash.size1(),0);
    }
}
