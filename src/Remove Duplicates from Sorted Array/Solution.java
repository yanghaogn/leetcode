public class Solution
{
    public int removeDuplicates(int[] A)
    {
        int result = A.length;
        int i, j;
        for (i = 1, j = 1; i < A.length; i++ )
        {
            if (A[i] == A[j - 1])
            {
                result-- ;
            }
            else
            {
                A[j] = A[i];
                j++ ;
            }
        }
        return result;
    }
}