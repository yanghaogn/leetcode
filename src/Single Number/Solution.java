public class Solution
{
    public int singleNumber(int[] A)
    {
        int result = 0;
        for (int element : A)
        {
            result = result ^ element;
        }
        return result;
    }
}