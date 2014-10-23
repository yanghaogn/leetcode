public class Solution
{
    public void merge(int A[], int m, int B[], int n)
    {
        int j = m + n - 1;
        m-- ;
        n-- ;
        while (m >= 0 && n >= 0)
        {
            if (A[m] >= B[n])
            {
                A[j-- ] = A[m-- ];
            }
            else
            {
                A[j-- ] = B[n-- ];
            }
        }
        while (n >= 0)
        {
            A[j-- ] = B[n-- ];
        }
    }
}