public class Solution
{
    public void setZeroes(int[][] matrix)
    {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
        {
            return;
        }
        LinkedList<Integer> ROW = new LinkedList<Integer>();
        LinkedList<Integer> COL = new LinkedList<Integer>();
        for (int row = 0; row < matrix.length; row++ )
        {
            for (int col = 0; col < matrix[row].length; col++ )
            {
                if (matrix[row][col] == 0)
                {
                    ROW.add(row);
                    COL.add(col);
                }
            }
        }
        for (int row : ROW)
        {
            for (int col = 0; col < matrix[row].length; col++ )
            {
                matrix[row][col] = 0;
            }
        }
        for (int col : COL)
        {
            for (int row = 0; row < matrix.length; row++ )
            {
                matrix[row][col] = 0;
            }
        }
    }
}