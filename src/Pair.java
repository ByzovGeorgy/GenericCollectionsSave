import javafx.beans.NamedArg;

/**
 * Created by SoniSSD on 17.12.2014.
 */
public class Pair<Key extends Comparable<Key>,Value extends Comparable<Value>> extends  javafx.util.Pair<Key,Value> implements Comparable<javafx.util.Pair<Key, Value>>{
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public Pair(@NamedArg("key") Key key, @NamedArg("value") Value value) {
        super(key, value);
    }
    @Override
    public int compareTo(javafx.util.Pair<Key, Value> o) {
        int cmp = compare(getKey(), o.getKey());
        return cmp == 0 ? compare(getValue(), o.getValue()) : cmp;
    }

    private static int compare(Object o1, Object o2) {
        return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1
                : ((Comparable) o1).compareTo(o2);
    }
}
