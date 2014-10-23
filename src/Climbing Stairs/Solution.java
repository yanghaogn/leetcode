public class Solution
{
    public int climbStairs(int n)
    {
        if (n < 4)
        {
            return n;
        }
        int low = 1;
        int up = 2;
        int p;
        for (int i = 3; i <= n; i++ )
        {
            p = low + up;
            low = up;
            up = p;
        }
        return up;
    }
}