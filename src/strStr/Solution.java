public class Solution
{
    public String strStr(String haystack, String needle)
    {
        if (needle == null || haystack == null)
        {
            return null;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i;
        int j;
        for (i = 0; i < needle.length(); i++ )
        {
            map.put(needle.charAt(i), i);
        }
        for (i = 0; i <= haystack.length() - needle.length();)
        {
            for (j = 0; j < needle.length(); j++ )
            {
                if (haystack.charAt(i + j) != needle.charAt(j))
                {
                    break;
                }
            }
            if (j == needle.length())
            {
                break;
            }
            if (i + j + 1 >= haystack.length() || !map.containsKey(haystack.charAt(i + j + 1)))
            {
                i = i + j + 2;
            }
            else
            {
                i = Math.max(i + 1, i + j + 1 - map.get(haystack.charAt(i + j + 1)));
            }
        }
        if (i > haystack.length() - needle.length())
        {
            return null;
        }
        return haystack.substring(i);
    }
}