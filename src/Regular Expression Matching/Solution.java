public class Solution
{
    public boolean match(char s, char p)
    {
        return s == p || p == '.';
    }

    public boolean isMatch(String s, String p)
    {
        int sLen = s.length();
        int pLen = p.length();
        int i;
        int j;
        int k;
        boolean[][] match = new boolean[sLen + 1][pLen + 1];
        match[0][0] = true;
        for (i = 0; i < sLen; i++ )
        {
            match[i + 1][0] = false;
        }
        for (j = 0; j < pLen; j++ )
        {
            if (p.charAt(j) == '*')
            {
                match[0][j + 1] = match[0][j - 1];
            }
            else
            {
                match[0][j + 1] = false;
            }
        }
        for (i = 0; i < sLen; i++ )
        {
            for (j = 0; j < pLen; j++ )
            {
                if (p.charAt(j) == '*')
                {
                    // 0个、1个或多个
                    match[i + 1][j + 1] = match[i + 1][j - 1]
                                          || match[i + 1][j]
                                          || (match(s.charAt(i), p.charAt(j - 1)) && match[i][j + 1]);
                }
                else
                {
                    match[i + 1][j + 1] = match(s.charAt(i), p.charAt(j)) && match[i][j];
                }
            }
        }
        return match[sLen][pLen];
    }
}