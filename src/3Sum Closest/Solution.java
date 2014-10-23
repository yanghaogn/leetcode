public class Solution
{
    public void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public void quickSort(int[] array, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        int middle = (start + end) / 2;
        swap(array, start, middle);
        int i = start + 1;
        while (i <= end)
        {
            if (array[i] >= array[start])
            {
                break;
            }
            i++ ;
        }
        int j = i + 1;
        for (; j <= end;)
        {
            while (j <= end)
            {
                if (array[j] < array[start])
                {
                    break;
                }
                j++ ;
            }
            if (j <= end)
            {
                swap(array, i, j);
                i++ ;
                j++ ;
            }
        }
        i-- ;
        if (array[i] < array[start])
        {
            swap(array, start, i);
        }
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
    }

    public int threeSumClosest(int[] num, int target)
    {
        int result = num[0] + num[1] + num[2];
        int diff = Math.abs(result - target);
        int sum;
        int newDiff;
        int i;
        int j;
        int k;
        quickSort(num, 0, num.length - 1);
        for (i = 0; i < num.length - 2; i++ )
        {
            j = i + 1;
            k = num.length - 1;
            while (j < k)
            {
                sum = num[i] + num[j] + num[k];
                newDiff = Math.abs(sum - target);
                if (newDiff < diff)
                {
                    diff = newDiff;
                    result = sum;
                }
                if (sum < target)
                {
                    j++ ;
                }
                else
                {
                    k-- ;
                }
            }
        }
        return result;
    }
}