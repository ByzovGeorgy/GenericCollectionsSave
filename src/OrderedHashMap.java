import javafx.util.Pair;

import java.util.Enumeration;
import java.util.LinkedList;

/**
 * Created by SoniSSD on 17.11.2014.
 */
public class OrderedHashMap<TKey extends Comparable<TKey>, TValue> implements OrderedSimpleMap<TKey,TValue>{
    public LinkedList<Pair<TKey,TValue>>[] A;
    private int Counter;
    public OrderedHashMap(){
        A=new LinkedList[64];
        for(int i=0;i<64;i++)
            A[i]=new LinkedList<Pair<TKey,TValue>>();
    }
    public OrderedHashMap(int length){
        A=new LinkedList[length];
        for(int i=0;i<length;i++)
            A[i]=new LinkedList<Pair<TKey,TValue>>();
    }
    public int size1(){
        return Counter;
    }
    public TValue get(TKey key){
        int hashKey=hashFunction(key) % A.length;
        for(Pair<TKey,TValue> i:A[hashKey])
        {
            if(i.getKey().equals(key))
                return i.getValue();
        }
        return  null;
    }
    public TValue put(TKey key,TValue value){
        int hashKey=hashFunction(key)%A.length;
        TValue oldValue;
        for(int i=0;i<A[hashKey].size();i++)
        {
            if(A[hashKey].get(i).getKey().equals(key))
            {
                oldValue=A[hashKey].get(i).getValue();
                A[hashKey].set(i,new Pair<TKey,TValue>(key,value));
                return oldValue;
            }
        }
        A[hashKey].addLast(new Pair<TKey, TValue>(key,value));
        Counter+=1;
        return null;
    }
    public TValue remove(TKey key){
        int hashKey=hashFunction(key) % A.length;
        TValue value;
        for(int i=0;i<A[hashKey].size();i++)
        {
            if(A[hashKey].get(i).getKey().equals(key))
            {
                value=A[hashKey].get(i).getValue();
                A[hashKey].remove(i);
                Counter-=1;
                return value;
            }
        }
        return null;
    }
    private int hashFunction(TKey key){
        return Math.abs(key.hashCode());
    }
}
