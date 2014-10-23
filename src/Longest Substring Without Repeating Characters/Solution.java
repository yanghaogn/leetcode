public class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(500);
        int start;
        int end;
        for (start = 0, end = 0; end < s.length(); end++ )
        {
            Integer value = map.get(s.charAt(end));
            int pStart = (value == null ? -1 : value);
            for (; start <= pStart; start++ )
            {
                map.remove(s.charAt(start));
            }
            map.put(s.charAt(end), end);
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}