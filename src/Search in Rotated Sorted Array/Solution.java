public class Solution
{
    int search(int[] A, int start, int end, int target)
    {
        if (start > end)
        {
            return -1;
        }
        if (start == end)
        {
            if (A[start] == target)
            {
                return start;
            }
            else
            {
                return -1;
            }
        }
        int middle = start + ((end - start) >> 1);
        if (A[middle] == target)
        {
            return middle;
        }
        if (A[middle] > target)
        {
            return search(A, start, middle - 1, target);
        }
        return search(A, middle + 1, end, target);
    }

    public int findMiddle(int[] A, int start, int end)
    {
        if (start >= end)
        {
            return -1;
        }
        if (start + 1 == end)
        {
            if (A[start] > A[end])
            {
                return start;
            }
            return -1;
        }
        if (A[start] < A[end])
        {
            return -1;
        }
        int middle = start + ((end - start) >> 1);
        if (A[middle] > A[start])
        {
            if (A[middle] > A[middle + 1])
            {
                return middle;
            }
            return findMiddle(A, middle, end);
        }
        else
        {
            return findMiddle(A, start, middle);
        }
    }

    public int search(int[] A, int target)
    {
        if (A == null)
        {
            return -1;
        }
        int middle = findMiddle(A, 0, A.length - 1);
        if (middle < 0)
        {
            return search(A, 0, A.length - 1, target);
        }
        else
        {
            if (A[0] > target)
            {
                return search(A, middle + 1, A.length - 1, target);
            }
            return search(A, 0, middle, target);
        }
    }
}
