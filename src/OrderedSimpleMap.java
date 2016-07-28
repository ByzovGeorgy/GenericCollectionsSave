/**
 * Created by SoniSSD on 15.11.2014.
 */
import  java.util.Collection.*;
public interface OrderedSimpleMap<TKey extends Comparable<TKey>, TValue>
{
    TValue get(TKey key);
    TValue put(TKey key, TValue value);
    TValue remove(TKey key);
}
