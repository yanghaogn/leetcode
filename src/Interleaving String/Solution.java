public class Solution
{
    boolean check[][];

    String s1;

    String s2;

    String s3;

    public boolean isInterleave(int m, int n)
    {
        if (check[m][n])
        {
            return false;
        }
        check[m][n] = true;
        if (m == s1.length())
        {
            for (; n < s2.length(); n++ )
            {
                if (s2.charAt(n) != s3.charAt(m + n))
                {
                    break;
                }
            }
            return n == s2.length();
        }
        if (n == s2.length())
        {
            for (; m < s1.length(); m++ )
            {
                if (s1.charAt(m) != s3.charAt(m + n))
                {
                    break;
                }
            }
            return m == s1.length();
        }
        if (s1.charAt(m) == s3.charAt(m + n))
        {
            if (isInterleave(m + 1, n))
            {
                return true;
            }
        }
        if (s2.charAt(n) == s3.charAt(m + n))
        {
            if (isInterleave(m, n + 1))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3)
    {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length())
        {
            return false;
        }
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        check = new boolean[m][n];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        for (int i = 0; i < m; i++ )
        {
            for (int j = 0; j < n; j++ )
            {
                check[i][j] = false;
            }
        }
        return isInterleave(0, 0);
    }
}