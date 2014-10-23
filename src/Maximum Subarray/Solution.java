public class Solution
{
    public int maxSubArray(int[] A)
    {
        if (A == null || A.length < 1)
        {
            return 0;
        }
        int result = A[0];
        int current = A[0];
        int LEN = A.length;
        for (int i = 1; i < LEN; i++ )
        {
            current = Math.max(A[i], current + A[i]);
            result = Math.max(current, result);
        }
        return result;
    }
}