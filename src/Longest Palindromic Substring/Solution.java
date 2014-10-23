public class Solution
{
    char special = 0;

    public String longestPalindrome(String s)
    {
        if (s == null || s.length() <= 1)
        {
            return s;
        }
        StringBuilder builder = new StringBuilder(2 * s.length() + 1);
        int i;
        for (i = 0; i < s.length(); i++ )
        {
            builder.append(special);
            builder.append(s.charAt(i));
        }
        builder.append(special);
        int[] p = new int[builder.length()];
        int maxPosition = 0;
        int central = 0;
        int index = 0;
        p[0] = 1;
        for (i = 1; i < builder.length(); i++ )
        {
            if (maxPosition >= i)
            {
                p[i] = Math.min(p[2 * central - i], maxPosition - i + 1);
            }
            else
            {
                p[i] = 1;
            }
            while (i - p[i] >= 0 && i + p[i] < builder.length())
            {
                if (builder.charAt(i - p[i]) == builder.charAt(i + p[i]))
                {
                    p[i]++ ;
                }
                else
                {
                    break;
                }
            }
            if (i + p[i] - 1 >= maxPosition)
            {
                central = i;
                maxPosition = i + p[i] - 1;
            }
            if (p[index] < p[i])
            {
                index = i;
            }
        }
        StringBuilder result = new StringBuilder(p[index] - 1);
        for (i = index - p[index] + 1; i < index + p[index]; i++ )
        {
            if (builder.charAt(i) != special)
            {
                result.append(builder.charAt(i));
            }
        }
        return result.toString();
    }
}