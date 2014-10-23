public class Solution
{
    public double pow(double x, int n)
    {
        boolean positive = true;
        long N = n;
        if (N < 0)
        {
            N = -N;
            positive = false;
        }
        double result = 1;
        double current = x;
        long p = 1;
        while (N > 0)
        {
            if ((N & p) > 0)
            {
                N -= p;
                result *= current;
            }
            current *= current;
            p = p << 1;
        }
        if (!positive)
        {
            result = 1 / result;
        }
        return result;
    }
}