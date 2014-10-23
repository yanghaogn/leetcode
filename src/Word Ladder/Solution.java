public class Solution
{
    public int ladderLength(String start, String end, Set<String> dict)
    {
        if (dict == null || dict.size() == 0)
        {
            return 0;
        }
        if (!dict.contains(start) || !dict.contains(end))
        {
            return 0;
        }
        if (start == end)
        {
            return 1;
        }
        LinkedList<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>(dict.size() * 2);
        Map<String, Integer> len = new HashMap<String, Integer>(dict.size() * 2);
        queue.add(start);
        visited.add(start);
        len.put(start, 1);
        for (String p = queue.poll(); p != null; p = queue.poll())
        {
            int LEN = len.get(p);
            for (int i = 0; i < p.length(); i++ )
            {
                StringBuilder builder = new StringBuilder(p);
                for (char c = 'a'; c <= 'z'; c++ )
                {
                    builder.setCharAt(i, c);
                    String dest = builder.toString();
                    if (dict.contains(dest) && !visited.contains(dest))
                    {
                        visited.add(dest);
                        queue.add(dest);
                        len.put(dest, LEN + 1);
                        if (dest.equals(end))
                        {
                            return LEN + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}