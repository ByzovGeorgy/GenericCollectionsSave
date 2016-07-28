import java.util.ArrayList;
import java.util.List;
/**
 * Created by SoniSSD on 13.11.2014.
 */
public class BinaryHeap implements Heap{
    private ArrayList<Integer> list;

    public BinaryHeap()
    {
        list=new ArrayList<Integer>();
    }
    public int length(){
        return list.size();
    }

    public void add(int element)
    {
        list.add(element);
        int i = list.size() - 1;
        int parent = (i - 1)/2;
        while ((i>0) && (list.get(i) > list.get(parent)))
        {
            int temp = list.get(parent);
            list.set(parent,list.get(i)) ;
            list.set(i,temp);
            i = parent;
            parent = (i - 1)/2;
        }
    }
    public int findMax()
    {
        return list.get(0);
    }

    public int deleteMax()
    {
        int result = list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        heapify(0);
        return result;
    }
    public void heapify(int i)
    {
        int left = 2*i+1;
        int right = 2*i + 2;
        int largest = i;
        if (left < list.size() && list.get(left) > list.get(largest))
            largest = left;
        if (right < list.size() && list.get(right) > list.get(largest))
            largest = right;
        if (largest != i)
        {
            int temp = list.get(i);
            list.set(i,list.get(largest));
            list.set(largest,temp);
            heapify(largest);
        }
    }
}
