public class Solution
{
    public int searchInsert(int[] A, int target)
    {
        if (target <= A[0])
        {
            return 0;
        }
        if (target > A[A.length - 1])
        {
            return A.length;
        }
        int start = 0;
        int end = A.length - 1;
        while (start <= end)
        {
            int middle = start + (end - start) / 2;
            if (A[middle] == target)
            {
                return middle;
            }
            else
            {
                if (target > A[middle])
                {
                    if (target <= A[middle + 1])
                    {
                        return middle + 1;
                    }
                    start = middle + 1;
                }
                else
                {
                    if (target > A[middle - 1])
                    {
                        return middle;
                    }
                    end = middle - 1;
                }

            }
        }
        return 0;
    }
}