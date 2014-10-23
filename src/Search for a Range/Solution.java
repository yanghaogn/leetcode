public class Solution
{
    public int[] searchRange(int[] A, int target)
    {
        int[] result = {-1, -1};
        if (A == null || A.length == 0)
        {
            return result;
        }
        int start = 0;
        int middle;
        int end = A.length - 1;
        while (start < end)
        {
            if (A[start] > target || A[end] < target)
            {
                return result;
            }
            middle = start + ((end - start) >> 1);
            if (A[middle] == target)
            {
                start = middle;
                end = middle;
                break;
            }
            if (A[middle] < target)
            {
                start = middle + 1;
                continue;
            }
            else
            {
                end = middle - 1;
                continue;
            }
        }
        if (start > end || A[start] != target)
        {
            return result;
        }
        while (start >= 0 && A[start] == target)
        {
            start-- ;
        }
        while (end < A.length && A[end] == target)
        {
            end++ ;
        }
        result[0] = start + 1;
        result[1] = end - 1;
        return result;
    }
}