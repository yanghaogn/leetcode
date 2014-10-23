public class Solution
{
    public int numTrees(int n)
    {
        if (n <= 2)
        {
            return n;
        }
        int num[] = new int[n + 1];
        int i;
        num[0] = 1;
        num[1] = 1;
        for (i = 2; i <= n; i++ )
        {
            num[i] = 0;
            for (int j = 0; j < i; j++ )
            {
                num[i] += num[j] * num[i - j - 1];
            }
        }
        return num[n];
    }
}