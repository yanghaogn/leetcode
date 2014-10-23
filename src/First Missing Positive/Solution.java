
/**
 * The basic idea is for any k positive numbers (duplicates allowed), the first missing positive number must be within [1,k+1]. The reason is like you put k balls into k+1 bins, there must be a bin empty, the empty bin can be viewed as the missing number.
 *  1. Unfortunately, there are 0 and negative numbers in the array, so firstly I think of using partition technique (used in quick sort) to put all positive numbers together in one side. This can be finished in O(n) time, O(1) space.
 *  2. After partition step, you get all the positive numbers lying within A[0,k-1]. Now, According to the basic idea, I infer the first missing number must be within [1,k+1]. I decide to use A[i] (0<=i<=k-1) to indicate whether the number (i+1) exists. But here I still have to main the original information A[i] holds. Fortunately, A[i] are all positive numbers, so I can set them to negative to indicate the existence of (i+1) and I can still use abs(A[i]) to get the original information A[i] holds.
 *  3. After step 2, I can again scan all elements between A[0,k-1] to find the first positive element A[i], that means (i+1) doesn't exist, which is what I want.
 */
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