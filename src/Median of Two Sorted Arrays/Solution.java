public class Solution
{
    public double findMedianSortedArrays(int A[], int B[])
    {
        if (A.length > B.length)
        {
            int C[] = A;
            A = B;
            B = C;
        }
        int aLen = A.length;
        int bLen = B.length;
        int k = (aLen + bLen - 1) / 2;
        int l = 0;
        int r = Math.min(aLen, k);
        int midA;
        int midB;
        while (l < r)
        {
            midA = (l + r) / 2;
            midB = k - midA;
            if (midB > k || A[midA] < B[midB])
            {
                l = midA + 1;
            }
            else
            {
                r = midA;
            }
        }
        double a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE,
            k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((aLen + bLen) & 1) == 1)
        {
            return a;
        }
        double b = Math.min(l < aLen ? A[l] : Integer.MAX_VALUE,
            k - l + 1 < bLen ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2;
    }

}