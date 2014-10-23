public class Solution
{
    int partition(int[] A)
    {
        int result = A.length - 1;
        for (int i = 0; i <= result;)
        {
            if (A[i] <= 0)
            {
                A[i] = A[result-- ];
            }
            else
            {
                i++ ;
            }
        }
        return result + 1;
    }

    public int firstMissingPositive(int[] A)
    {
        if (A == null || A.length == 0)
        {
            return 1;
        }
        int n = partition(A);
        for (int i = 0; i < n; i++ )
        {
            int temp = Math.abs(A[i]);
            if (temp <= n)
            {
                A[temp - 1] = A[temp - 1] > 0 ? -A[temp - 1] : A[temp - 1];
            }
        }
        for (int i = 0; i < n; i++ )
        {
            if (A[i] > 0)
            {
                return i + 1;
            }
        }
        return n + 1;
    }
}