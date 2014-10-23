public class Solution
{
    public int lengthOfLastWord(String s)
    {
        if (s == null || s.length() <= 0)
        {
            return 0;
        }
        int end = s.length();
        int start = end - 1;
        for (; start >= 0; start-- )
        {
            if (s.charAt(start) == ' ')
            {
                if (end == start + 1)
                {
                    end = start;
                }
                else
                {
                    break;
                }
            }
        }
        return end - start - 1;
    }
}