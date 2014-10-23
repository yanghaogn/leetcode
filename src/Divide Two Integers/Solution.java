public class Solution
{
    public int divide(int dividend, int divisor)
    {
        int result = 0;
        int p = 0;
        long currentSum = 0;
        boolean positive = true;
        long fenmu = divisor;
        long fenzi = dividend;
        if (fenmu < 0)
        {
            fenmu = -fenmu;
            if (fenzi < 0)
            {
                fenzi = -fenzi;
            }
            else
            {
                positive = false;
            }
        }
        else
        {
            if (fenzi < 0)
            {
                fenzi = -fenzi;
                positive = false;
            }
        }
        while (currentSum < fenzi)
        {
            if (p == 0)
            {
                p++ ;
                currentSum += fenmu;
            }
            else
            {
                if (fenzi - currentSum > currentSum)
                {
                    p += p;
                    currentSum += currentSum;
                }
                else
                {
                    result += p;
                    fenzi -= currentSum;
                    p = 0;
                    currentSum = 0;
                }
            }
        }
        result += p;
        fenzi -= currentSum;
        if (fenzi == 0)
        {
            result = positive ? result : -result;
        }
        else
        {
            result-- ;
            result = positive ? result : -result;
        }
        return result;
    }
}