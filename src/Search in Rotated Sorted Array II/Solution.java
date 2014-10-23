public class Solution
{
    public boolean search(int[] A, int target)
    {
        if (A == null)
        {
            return false;
        }
        int left = 0;
        int right = A.length - 1;
        int middle;
        while (left <= right)
        {
            middle = left + (right - left) / 2;
            if (A[middle] == target)
            {
                return true;
            }
            if (A[left] == A[right])
            {
                left++ ;
                continue;
            }
            if (A[left] <= A[middle])
            {
                if (A[left] <= target && target <= A[middle])
                {
                    right = middle - 1;
                }
                else
                {
                    left = middle + 1;
                }
            }
            else
            {
                if (A[middle] < target && target <= A[right])
                {
                    left = middle + 1;
                }
                else
                {
                    right = middle - 1;
                }
            }
        }
        return false;
    }
}