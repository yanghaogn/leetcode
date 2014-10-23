public class Solution
{
    public void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length <= 1)
        {
            return;
        }
        int N = matrix.length - 1;
        for (int x = 0; x <= N; x++ )
        {
            for (int y = 0; y <= x && x + y < N; y++ )
            {
                int p = matrix[x][y];
                matrix[x][y] = matrix[N - y][x];
                matrix[N - y][x] = matrix[N - x][N - y];
                matrix[N - x][N - y] = matrix[y][N - x];
                matrix[y][N - x] = p;
            }
        }
    }
}