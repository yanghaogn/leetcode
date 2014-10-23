public class Solution
{
    boolean isAnInteger(String s)
    {
        int LEN = s.length();
        if (LEN == 0) return false;
        int i = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-')
        {
            i++ ;
            if (i == LEN) return false;
        }
        for (; i < LEN; i++ )
        {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    boolean isAnDouble(String s)
    {
        int LEN = s.length();
        if (LEN == 0) return false;
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-')
        {
            i++ ;
            if (i == LEN) return false;
        }
        int numPoint = 0;
        int numN = 0;
        for (; i < LEN; i++ )
        {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
            {
                numN++ ;
                continue;
            }
            if (c == '.')
            {
                numPoint++ ;
                continue;
            }
            return false;
        }
        return numN > 0 && numPoint <= 1;
    }

    public boolean isNumber(String s)
    {
        if (s == null) return false;
        s = s.trim();
        int LEN = s.length();
        if (LEN == 0) return false;
        int indexE = s.indexOf('e');
        if (indexE < 0) return isAnDouble(s);
        if (indexE + 1 == LEN) return false;
        return isAnDouble(s.substring(0, indexE)) && isAnInteger(s.substring(indexE + 1));
    }
}