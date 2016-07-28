import java.util.ArrayList;

/**
 * Created by SoniSSD on 15.11.2014.
 */
public class OrderedBinaryHeap<TValue extends Comparable<TValue>> implements OrderedHeap<TValue> {
    private ArrayList<TValue> list;


    public OrderedBinaryHeap()
    {
        list=new ArrayList<TValue>();
    }
    public int length(){
        return list.size();
    }

    public void add(TValue element)
    {
        list.add(element);
        int i = list.size() - 1;
        int parent = (i - 1)/2;
        while ((i>0) && (list.get(i).compareTo(list.get(parent))<0))
        {
            TValue temp = list.get(parent);
            list.set(parent,list.get(i)) ;
            list.set(i,temp);
            i = parent;
            parent = (i - 1)/2;
        }
    }
    public TValue findMax()
    {
        return list.get(0);
    }

    public TValue deleteMax()
    {
        TValue result = list.get(0);
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
        if (left < list.size() && list.get(left).compareTo(list.get(largest))<0)
            largest = left;
        if (right < list.size() && list.get(right).compareTo(list.get(largest))<0)
            largest = right;
        if (largest != i)
        {
            TValue temp = list.get(i);
            list.set(i,list.get(largest));
            list.set(largest,temp);
            heapify(largest);
        }
    }
}
