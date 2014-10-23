public class Solution
{
    public int removeElement(int[] A, int elem)
    {
        int result = A.length;
        for (int i = 0, j = 0; i < A.length; i++ )
        {
            if (A[i] != elem)
            {
                A[j++ ] = A[i];
            }
            else
            {
                result-- ;
            }
        }
        return result;
    }
}