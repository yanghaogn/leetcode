public class Solution
{
    char toLowerCase(char c)
    {
        if (c >= 'A' && c <= 'Z')
        {
            c += 32;
        }
        return c;
    }

    boolean isAlphanumeric(char c)
    {
        if (c >= 'a' && c <= 'z')
        {
            return true;
        }
        if (c >= '0' && c <= '9')
        {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s)
    {
        if (s == null || s.length() <= 1)
        {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char start;
        char end;
        while (i < j)
        {
            start = toLowerCase(s.charAt(i));
            end = toLowerCase(s.charAt(j));
            if (!isAlphanumeric(start))
            {
                i++ ;
                continue;
            }
            if (!isAlphanumeric(end))
            {
                j-- ;
                continue;
            }
            if (start != end)
            {
                return false;
            }
            i++ ;
            j-- ;
        }
        return true;
    }
}