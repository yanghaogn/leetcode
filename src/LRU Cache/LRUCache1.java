import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class LRUCache
{
    LinkedHashMap<Integer, Integer> cache;

    static int capacity;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity * 2)
        {

            @Override
            protected boolean removeEldestEntry(Entry<Integer, Integer> eldest)
            {
                // TODO Auto-generated method stub
                return size() > LRUCache.capacity;
            }

        };
    }

    public int get(int key)
    {
        Integer value = cache.get(key);
        if (value == null) return -1;
        return value;
    }

    public void set(int key, int value)
    {
        cache.put(key, value);
    }
}
