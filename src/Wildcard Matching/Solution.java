public class Solution
{

    public boolean isMatch(String str, String pattern)
    {
        int sLen = str.length();
        int pLen = pattern.length();
        int i = 0;
        int j = 0;
        int pStr = -1;
        int pPattern = -1;
        while (i < sLen)
        {
            if (j < pLen && (pattern.charAt(j) == '?' || pattern.charAt(j) == str.charAt(i)))
            {
                i++ ;
                j++ ;
            }
            else if (j < pLen && pattern.charAt(j) == '*')
            {
                pStr = i;
                pPattern = j;
                j++ ;
            }
            else if (pPattern != -1)
            {
                pStr++ ;
                i = pStr;
                j = pPattern + 1;
            }
            else
            {
                return false;
            }
        }
        while (j < pLen && pattern.charAt(j) == '*')
        {
            j++ ;
        }
        return j == pLen;
    }
}