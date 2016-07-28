import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by SoniSSD on 16.11.2014.
 */
public class HashMap implements SimpleMap{
    private LinkedList<Pair<String,Integer>>[] A;
    public HashMap(){
        A=new LinkedList[64];
        for(int i=0;i<64;i++)
            A[i]=new LinkedList<Pair<String, Integer>>();
    }
    public HashMap(int length){
        A=new LinkedList[length];
        for(int i=0;i<length;i++)
            A[i]=new LinkedList<Pair<String, Integer>>();
    }
    public Integer get(String key){
        int hashKey=hashFunction(key) % A.length;
        for(Pair<String,Integer> i:A[hashKey])
        {
            if(i.getKey().equals(key))
                return i.getValue();
        }
        return  null;
    }
    public Integer put(String key,int value){
        int hashKey=hashFunction(key)%A.length;
        Integer oldValue;
        for(int i=0;i<A[hashKey].size();i++)
        {
            if(A[hashKey].get(i).getKey().equals(key))
            {
                oldValue=A[hashKey].get(i).getValue();
                A[hashKey].set(i,new Pair<String, Integer>(key,value));
                return oldValue;
            }
        }
        A[hashKey].addLast(new Pair<String, Integer>(key,value));
        return null;
    }
    public Integer remove(String key){
        int hashKey=hashFunction(key) % A.length;
        Integer value;
        for(int i=0;i<A[hashKey].size();i++)
        {
            if(A[hashKey].get(i).getKey().equals(key))
            {
                value=A[hashKey].get(i).getValue();
                A[hashKey].remove(i);
                return value;
            }
        }
        return null;
    }
    private int hashFunction(String key){
        return Math.abs(key.hashCode());
    }
}
