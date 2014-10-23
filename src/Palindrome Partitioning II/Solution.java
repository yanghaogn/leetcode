public class Solution
{
    public int minCut(String s)
    {
        int N = s.length();
        int minCuts[] = new int[N + 1];
        int i;
        for (i = 0; i <= N; i++ )
        {
            minCuts[i] = i - 1;
        }
        for (i = 0; i < N; i++ )
        {
            // odd
            for (int j = 0; i - j >= 0 && i + j < N && s.charAt(i - j) == s.charAt(i + j); j++ )
            {
                minCuts[i + j + 1] = Math.min(minCuts[i + j + 1], 1 + minCuts[i - j]);
            }
            // even
            for (int j = 1; i - j + 1 >= 0 && i + j < N && s.charAt(i - j + 1) == s.charAt(i + j); j++ )
            {
                minCuts[i + j + 1] = Math.min(minCuts[i + j + 1], 1 + minCuts[i - j + 1]);
            }
        }
        return minCuts[N];
    }
}