public class Solution
{
    public int strStr(String haystack, String needle)
    {
        if (needle == null || haystack == null)
        {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int index;
        int j;
        for (index = 0; index < needle.length(); index++ )
        {
            map.put(needle.charAt(index), index);
        }
        for (index = 0; index <= haystack.length() - needle.length();)
        {
            for (j = 0; j < needle.length(); j++ )
            {
                if (haystack.charAt(index + j) != needle.charAt(j))
                {
                    break;
                }
            }
            if (j == needle.length())
            {
                break;
            }
            if (index + j + 1 >= haystack.length()
                || !map.containsKey(haystack.charAt(index + j + 1)))
            {
                index = index + j + 2;
            }
            else
            {
                index = Math.max(index + 1,
                    index + j + 1 - map.get(haystack.charAt(index + j + 1)));
            }
        }
        if (index > haystack.length() - needle.length())
        {
            return -1;
        }
        return index;
    }
}
