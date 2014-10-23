public class Solution
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return result;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        while (true)
        {
            // 向右
            for (col = left; col <= right; col++ )
            {
                result.add(matrix[row][col]);
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
                result.add(matrix[row][col]);
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
                result.add(matrix[row][col]);
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
                result.add(matrix[row][col]);
            }
            left++ ;
            if (left > right)
            {
                break;
            }
            row++ ;
        }
        return result;
    }
}