public class Solution
{
    public List<Integer> getRow(int rowIndex)
    {
        ArrayList<Integer> p = new ArrayList<Integer>();
        if (rowIndex < 0)
        {
            return p;
        }
        int array[] = new int[rowIndex + 1];
        int i, j;
        for (i = 0; i <= rowIndex; i++ )
        {
            array[i] = 1;
        }
        for (i = 2; i <= rowIndex; i++ )
        {
            for (j = i - 1; j > 0; j-- )
            {
                array[j] += array[j - 1];
            }
        }
        for (int value : array)
        {
            p.add(value);
        }
        return p;
    }
}