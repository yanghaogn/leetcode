public class Solution
{
    public int longestConsecutive(int[] num)
    {
        if (num == null || num.length == 0)
        {
            return 0;
        }
        int result = 1;
        HashSet<Integer> set = new HashSet<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int element : num)
        {
            set.add(element);
        }
        for (int element : num)
        {
            if (map.containsKey(element))
            {
                continue;
            }
            int end = element;
            for (end = element + 1; set.contains(end) && !map.containsKey(end); end++ );
            int len = end - element;
            if (map.containsKey(end))
            {
                len += map.get(end);
            }
            result = Math.max(len, result);
            for (int i = element; i < end; i++ , len-- )
            {
                map.put(i, len);
            }
        }
        return result;
    }
}