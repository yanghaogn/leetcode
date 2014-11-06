public class Solution
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (triangle == null || triangle.size() == 0)
        {
            return 0;
        }
        int ROW = triangle.size();
        int result[] = new int[ROW];
        int row = ROW - 1;
        int col;
        List<Integer> list = triangle.get(row);
        for (col = 0; col <= row; col++ )
        {
            result[col] = list.get(col);
        }
        for (row = ROW - 2; row >= 0; row-- )
        {
            list = triangle.get(row);
            for (col = 0; col <= row; col++ )
            {
                result[col] = list.get(col) + Math.min(result[col], result[col + 1]);
            }
        }
        return result[0];
    }
}
