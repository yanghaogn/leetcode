public class Solution
{
    public int removeDuplicates(int[] A)
    {
        int result = A.length;
        int i, j;
        for (i = 2, j = 2; i < A.length; i++ )
        {
            if ((A[i] == A[j - 1]) && (A[i] == A[j - 2]))
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