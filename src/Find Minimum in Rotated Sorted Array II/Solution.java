public class Solution
{
    public int findMin(int[] num)
    {
        int start = 0;
        int end = num.length - 1;
        while (start < end&&num[start]>=num[end])
        {
            int middle = start + ((end - start) >> 1);
            if (num[start] == num[end] && num[middle] == num[end])
            {
                start++ ;
                end-- ;
                continue;
            }
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
