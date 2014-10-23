public class Solution
{
    public int trap(int[] A)
    {
        if (A == null || A.length <= 2)
        {
            return 0;
        }
        int N = A.length;
        int[] left = new int[N];
        int result = 0;
        left[0] = A[0];
        for (int index = 1; index < N; index++ )
        {
            left[index] = Math.max(left[index - 1], A[index]);
        }
        for (int i = N - 1; i > 0; i-- )
        {
            int height = Math.min(left[i - 1], A[i]);
            for (int j = i - 1; A[j] < height; j-- )
            {
                result += height - A[j];
                A[j] = height;
            }
        }
        return result;
    }
}