public class Solution
{
    public String convert(String s, int nRows)
    {
        if (s == null || s.length() <= 1 || nRows == 1)
        {
            return s;
        }
        StringBuilder result = new StringBuilder(s.length());
        int LEN = 2 * nRows - 2;
        int times = s.length() / LEN + 1;
        for (int row = 0; row < nRows; row++ )
        {
            int p1 = row;
            int p2 = row == nRows - 1 ? LEN + row : LEN - row;
            if (p1 < s.length())
            {
                result.append(s.charAt(p1));
            }
            if (p2 < s.length())
            {
                result.append(s.charAt(p2));
            }
            for (int i = 0; i < times; i++ )
            {
                p1 += LEN;
                if (p1 != p2 && p1 < s.length())
                {
                    result.append(s.charAt(p1));
                }
                p2 += LEN;
                if (p2 < s.length())
                {
                    result.append(s.charAt(p2));
                }
            }
        }
        return result.toString();
    }
}