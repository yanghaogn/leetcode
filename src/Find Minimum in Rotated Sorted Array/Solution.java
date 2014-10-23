public class Solution
{
    public int findMin(int[] num)
    {
        int start = 0;
        int end = num.length - 1;
        int middle;
        while (num[start] > num[end])
        {
            middle = start + ((end - start) >> 1);
            if (num[middle] > num[end])
            {
                start = middle + 1;
            }
            else
            {
                end = middle;
            }
        }
        return num[start];
    }
}