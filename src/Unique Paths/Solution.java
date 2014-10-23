public class Solution
{
    public int uniquePaths(int m, int n)
    {
        if (m <= 0 || n <= 0)
        {
            return 0;
        }
        if (n > m)
        {
            return uniquePaths(n, m);
        }
        int[] ROW = new int[n];
        int row;
        int col;
        for (col = 0; col < n; col++ )
        {
            ROW[col] = 1;
        }
        for (row = m - 2; row >= 0; row-- )
        {
            for (col = n - 2; col >= 0; col-- )
            {
                ROW[col] = ROW[col] + ROW[col + 1];
            }
        }
        return ROW[0];
    }
}