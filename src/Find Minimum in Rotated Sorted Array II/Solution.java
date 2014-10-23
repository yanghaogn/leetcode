public class Solution
{
    int[] num;

    public int findMin(int start, int end)
    {
        if (start == end)
        {
            return num[start];
        }
        if (num[start] == num[end])
        {
            return findMin(start + 1, end);
        }
        int middle = start + ((end - start) >> 1);
        if (num[middle] > num[end])
        {
            return findMin(middle + 1, end);
        }
        return findMin(start, middle);
    }

    public int findMin(int[] num)
    {
        this.num = num;
        return findMin(0, num.length - 1);
    }
}