public class LRUCache
{
    public static class Trible
    {
        int value;

        int priorKey;

        int nextKey;

        Trible(int value, int preciousKey, int nextKey)
        {
            this.value = value;
            this.priorKey = preciousKey;
            this.nextKey = nextKey;
        }
    }

    final int capacity;

    HashMap<Integer, Trible> cache = new HashMap<Integer, Trible>();

    int firstKey;

    int lastKey;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        Trible current = cache.get(key);
        if (current == null) return -1;
        moveToLast(key);
        return current.value;
    }

    public void moveToLast(int key)
    {
        if (cache.size() == 1 || lastKey == key) return;
        Trible current = cache.get(key);
        Trible prior = cache.get(current.priorKey);
        Trible next = cache.get(current.nextKey);
        if (firstKey == key)
        {
            firstKey = current.nextKey;
        }
        else
        {
            prior.nextKey = current.nextKey;
            next.priorKey = current.priorKey;
        }
        current.priorKey = lastKey;
        cache.get(lastKey).nextKey = key;
        lastKey = key;
    }

    public void set(int key, int value)
    {
        Trible t;
        if (cache.size() == 0)
        {
            t = new Trible(value, key, key);
            firstKey = key;
            lastKey = key;
            cache.put(key, t);
            return;
        }
        t = cache.get(key);
        if (t == null)
        {
            t = new Trible(value, key, key);
            cache.get(lastKey).nextKey = key;
            t.priorKey = lastKey;
            lastKey = key;
            cache.put(key, t);
        }
        else
        {
            t.value = value;
            moveToLast(key);
        }
        if (cache.size() > capacity)
        {
            firstKey = cache.get(firstKey).nextKey;
            cache.remove(cache.get(firstKey).priorKey);
        }
    }
}
