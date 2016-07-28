/**
 * Created by SoniSSD on 15.11.2014.
 */
public interface OrderedHeap<TValue extends Comparable<TValue>> {
    void add(TValue element);
    TValue findMax();
    TValue deleteMax();
}
