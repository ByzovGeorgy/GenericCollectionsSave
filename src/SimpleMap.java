/**
 * Created by SoniSSD on 13.11.2014.
 */
public interface SimpleMap {
    Integer get(String key);
    Integer put(String key, int value);
    Integer remove(String key);
}
