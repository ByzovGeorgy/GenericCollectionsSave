public class MyPair<FIRST, SECOND> implements Comparable<MyPair<FIRST, SECOND>> {

    public final FIRST first;
    public final SECOND second;

    public MyPair(FIRST first, SECOND second) {
        this.first = first;
        this.second = second;
    }

    public static <FIRST, SECOND> MyPair<FIRST, SECOND> of(FIRST first,
                                                         SECOND second) {
        return new MyPair<FIRST, SECOND>(first, second);
    }


    @Override
    public int compareTo(MyPair<FIRST, SECOND> o) {
        int cmp = compare(first, o.first);
        return cmp == 0 ? compare(second, o.second) : cmp;
    }

    private static int compare(Object o1, Object o2) {
        return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1
                : ((Comparable) o1).compareTo(o2);
    }


    @Override
    public String toString() {
        return second.toString();
    }
}