public class Solution
{
    String toAscendingString(String s)
    {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public boolean isAnagram(String first, String second)
    {
        int LEN = first.length();
        for (int i = 0; i < LEN; i++ )
        {
            if (first.charAt(i) != second.charAt(LEN - i - 1))
            {
                return false;
            }
        }
        return true;
    }

    public List<String> anagrams(String[] strs)
    {
        List<String> result = new LinkedList<String>();
        if (strs == null || strs.length == 0)
        {
            return result;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>(strs.length * 2);
        for (String s : strs)
        {
            String p = toAscendingString(s);
            if (map.containsKey(p))
            {
                map.get(p).add(s);
            }
            else
            {
                List<String> list = new LinkedList<String>();
                list.add(s);
                map.put(p, list);
            }
        }
        for (List<String> list : map.values())
        {
            if (list.size() >= 2)
            {
                result.addAll(list);
            }
        }
        return result;
    }
}