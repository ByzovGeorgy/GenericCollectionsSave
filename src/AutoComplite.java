import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoniSSD on 20.11.2014.
 */
public class AutoComplite {
    private OrderedHashMap<String,Integer> hashMap;
    private OrderedBinaryHeap<MyPair<Integer,String>> timeQueue;
    private static Integer counter=0;
    private static int counterWords;
    private int l;
    public AutoComplite(int lenght)
    {
        l=lenght;
        hashMap=new OrderedHashMap<String, Integer>(lenght);
        timeQueue=new OrderedBinaryHeap<MyPair<Integer,String>>();
    }
    public void add(String word)
    {
        if(hashMap.get(word)!=null)
        {
            hashMap.put(word, counter);
            timeQueue.add(new MyPair<Integer, String>(counter, word));
            counter++;
        }
        else {
            if (counterWords == l) {
                boolean flag = true;
                MyPair<Integer, String> minWord = timeQueue.findMax();
                for (;flag;) {
                    minWord = timeQueue.findMax();
                    timeQueue.deleteMax();
                    if (hashMap.get(minWord.second) == minWord.first) {
                        flag = false;
                    }
                }
                hashMap.remove(minWord.toString());
                counterWords--;
            }
            hashMap.put(word, counter);
            timeQueue.add(new MyPair<Integer, String>(counter,word));
            counterWords++;
            counter++;
        }
    }
    public ArrayList<String> prefix(String key)
    {
        int count=0;
        ArrayList<String> strings= new ArrayList<String>();
        jj:for(int i=0;i<l;i++)
        {
            for(Pair<String,Integer> pair:hashMap.A[i])
            {
                if(key.equals(pair.getKey().substring(0,key.length())))
                {
                    strings.add(pair.getKey());
                    count++;
                    System.out.println(pair.getKey());
                }
                if(count==10)
                    break jj;
            }
        }
        return strings;
    }
}
