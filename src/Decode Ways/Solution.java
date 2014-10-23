public class Solution
{
    int num[];

    public int getNum(String s, int index)
    {
        if (index >= s.length())
        {
            return 0;
        }
        if (num[index] != -1)
        {
            return num[index];
        }
        int first = s.charAt(index) - '0';
        int second = s.charAt(index + 1) - '0';
        num[index] = getNum(s, index + 1);
        if (first * 10 + second <= 26)
        {
            num[index] += getNum(s, index + 2);
            if (index + 2 == s.length())
            {
                num[index]++ ;
            }
        }
        return num[index];
    }

    public int numDecodings(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        num = new int[s.length()];
        for (int i = 0; i < num.length; i++ )
        {
            num[i] = -1;
            if (s.charAt(i) <= '0' || s.charAt(i) > '9')
            {
                num[i] = 0;
            }
        }
        num[s.length() - 1] = num[s.length() - 1] == -1 ? 1 : 0;
        return getNum(s, 0);
    }
}