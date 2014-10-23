public class Solution
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
        {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] number = new int[n];
        int row = m - 1;
        int col = n - 1;
        number[col] = obstacleGrid[row][col] == 0 ? 1 : 0;
        for (col = n - 2; col >= 0; col-- )
        {
            number[col] = obstacleGrid[row][col] == 0 ? number[col + 1] : 0;
        }
        for (row = m - 2; row >= 0; row-- )
        {
            number[n - 1] = obstacleGrid[row][n - 1] == 0 ? number[n - 1] : 0;
            for (col = n - 2; col >= 0; col-- )
            {
                number[col] = obstacleGrid[row][col] == 0 ? (number[col] + number[col + 1]) : 0;
            }
        }
        return number[0];
    }
}