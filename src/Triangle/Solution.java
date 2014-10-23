public class Solution
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (triangle == null || triangle.size() == 0)
        {
            return 0;
        }
        final int ROW = triangle.size();
        int NUM = ROW * (ROW + 1) / 2;
        int minValue[] = new int[NUM];
        int position = 0;
        int row = 0, col;
        int rowStartIndex = 0;
        int result;
        minValue[position++ ] = triangle.get(0).get(0);
        for (row = 1; row < ROW; row++ )
        {
            rowStartIndex += row;
            List<Integer> rowList = triangle.get(row);
            minValue[position++ ] = rowList.get(0) + minValue[rowStartIndex - row];
            int left = rowStartIndex - row;
            for (col = 1; col < row; col++ )
            {
                minValue[position++ ] = Math.min(minValue[left], minValue[left + 1])
                                        + rowList.get(col);
                left++ ;
            }
            minValue[position++ ] = rowList.get(row) + minValue[rowStartIndex - 1];
        }
        result = minValue[rowStartIndex];
        for (int i = 1; i < ROW; i++ )
        {
            result = Math.min(minValue[rowStartIndex + i], result);
        }
        return result;
    }
}