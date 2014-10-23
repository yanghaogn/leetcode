public class Solution
{
    public int minPathSum(int[][] grid)
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] DISTANCE = new int[ROW][COL];
        int row, col;
        DISTANCE[0][0] = grid[0][0];
        for (col = 1; col < COL; col++ )
        {
            DISTANCE[0][col] = DISTANCE[0][col - 1] + grid[0][col];
        }
        for (row = 1; row < ROW; row++ )
        {
            DISTANCE[row][0] = DISTANCE[row - 1][0] + grid[row][0];
        }
        for (col = 1; col < COL; col++ )
        {
            for (row = 1; row < ROW; row++ )
            {
                DISTANCE[row][col] = Math.min(DISTANCE[row - 1][col], DISTANCE[row][col - 1])
                                     + grid[row][col];
            }
        }
        return DISTANCE[ROW - 1][COL - 1];
    }
}