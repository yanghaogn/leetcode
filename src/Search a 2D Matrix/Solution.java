public class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        int ROW = matrix.length;
        int COL = matrix[0].length;
        int[] firstCOL = new int[ROW];
        int row;
        int col;
        int start;
        int end;
        // locate the row
        for (row = 0; row < ROW; row++ )
        {
            firstCOL[row] = matrix[row][0];
        }
        start = 0;
        end = ROW - 1;
        while (start < end)
        {
            int middle = start + (end - start >> 1);
            if (firstCOL[middle] <= target && firstCOL[middle + 1] > target)
            {
                start = middle;
                end = middle;
                break;
            }
            if (firstCOL[middle] > target)
            {
                end = middle;
            }
            else
            {
                start = middle + 1;
            }
        }
        if (start > end || matrix[start][0] > target || matrix[start][COL - 1] < target)
        {
            return false;
        }
        row = start;
        // locate the col
        start = 0;
        end = COL - 1;
        while (start <= end)
        {
            int middle = start + ((end - start) >> 1);
            if (matrix[row][middle] == target)
            {
                return true;
            }
            if (matrix[row][middle] < target)
            {
                start = middle + 1;
            }
            else
            {
                end = middle - 1;
            }
        }
        return false;
    }
}