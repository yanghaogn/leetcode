public class Solution
{
    public int maxProduct(int[] A)
    {
        int max = A[0];
        int min = A[0];
        int result = A[0];
        for (int i = 1; i < A.length; i++ )
        {
            int pMax = Math.max(A[i], Math.max(A[i] * min, A[i] * max));
            int pMin = Math.min(A[i], Math.min(A[i] * min, A[i] * max));
            max = pMax;
            min = pMin;
            result = Math.max(result, max);
        }
        return result;
    }
}