public class Solution
{
    public int[][] generateMatrix(int n)
    {
        if (n < 0)
        {
            return null;
        }
        int[][] matrix = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int row = 0;
        int col = 0;
        int currentValue = 1;
        while (true)
        {
            // 向右
            for (col = left; col <= right; col++ )
            {
                matrix[row][col] = currentValue++ ;
            }
            up++ ;
            if (up > down)
            {
                break;
            }
            col-- ;
            // 向下
            for (row = up; row <= down; row++ )
            {
                matrix[row][col] = currentValue++ ;
            }
            right-- ;
            if (left > right)
            {
                break;
            }
            row-- ;
            // 向左
            for (col = right; col >= left; col-- )
            {
                matrix[row][col] = currentValue++ ;
            }
            down-- ;
            if (up > down)
            {
                break;
            }
            col++ ;
            // 向上
            for (row = down; row >= up; row-- )
            {
                matrix[row][col] = currentValue++ ;
            }
            left++ ;
            if (left > right)
            {
                break;
            }
            row++ ;
        }
        return matrix;
    }
}