public class Solution
{
    public int sqrt(int x)
    {
        if (x == 0)
        {
            return 0;
        }
        if (x < 4)
        {
            return 1;
        }
        int n = 15;
        long result = 0;
        long maxNum;
        for (; n >= 0; n-- )
        {
            maxNum = 1 << n;
            if ((result + maxNum) * (result + maxNum) <= x)
            {
                result += maxNum;
            }
        }
        return (int)result;
    }
}