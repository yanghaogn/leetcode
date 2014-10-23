public class Solution
{
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    String roman = "MDCLXVI";
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s)
    {
        int result = 0;
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        if (s.length() == 1)
        {
            return map.get(s.charAt(0));
        }
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < roman.length(); i++ )
        {
            startIndex = s.indexOf(roman.charAt(i));
            if (startIndex >= 0)
            {
                for (endIndex = startIndex; endIndex < s.length(); endIndex++ )
                {
                    if (s.charAt(endIndex) != s.charAt(startIndex))
                    {
                        break;
                    }
                }
                break;
            }
        }
        result = (endIndex - startIndex) * map.get(s.charAt(startIndex));
        if (startIndex > 0)
        {
            result -= romanToInt(s.substring(0, startIndex));
        }
        if (endIndex < s.length())
        {
            result += romanToInt(s.substring(endIndex));
        }
        return result;
    }
}