public class Solution
{
    public String countAndSay(int n)
    {
        StringBuilder result = new StringBuilder(n);
        StringBuilder p = new StringBuilder(n);
        int i;
        int j;
        result.append("1");
        while (n-- > 1)
        {
            for (i = 0, j = 0; i < result.length(); i = j)
            {
                while (j < result.length() && result.charAt(j) == result.charAt(i))
                {
                    j++ ;
                }
                int len = j - i;
                p.append("" + len + result.charAt(i));
            }
            StringBuilder tmp = p;
            p = result;
            result = tmp;
            p.delete(0, p.length());
        }
        return result.toString();
    }
}