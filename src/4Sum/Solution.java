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

    List<List<Integer>> twoSum(int[] array, int startIndex, int endIndex, int dest)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        while (endIndex > startIndex)
        {
            int sum = array[startIndex] + array[endIndex];
            if (sum == dest)
            {
                List<Integer> p = new LinkedList<Integer>();
                p.add(array[startIndex]);
                p.add(array[endIndex]);
                result.add(p);
                for (startIndex++ ; startIndex <= endIndex; startIndex++ )
                {
                    if (array[startIndex] != array[startIndex - 1])
                    {
                        break;
                    }
                }
            }
            if (sum > dest)
            {
                endIndex-- ;
            }
            if (sum < dest)
            {
                startIndex++ ;
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] num, int target)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length < 4)
        {
            return result;
        }
        int[] array = new int[num.length];
        for (int i = 0; i < num.length; i++ )
        {
            array[i] = num[i];
        }
        quickSort(array, 0, array.length - 1);
        int start = 0;
        int end = array.length - 1;
        for (start = 0; start < array.length - 3;)
        {
            for (end = array.length - 1; end - start >= 2;)
            {
                List<List<Integer>> list = twoSum(array, start + 1, end - 1, target - array[start]
                                                                             - array[end]);
                for (List<Integer> p : list)
                {
                    p.add(0, array[start]);
                    p.add(array[end]);
                    result.add(p);
                }
                for (end-- ; start < end; end-- )
                {
                    if (array[end] != array[end + 1]) break;
                }
            }
            for (start++ ; start < array.length; start++ )
            {
                if (array[start] != array[start - 1]) break;
            }

        }
        return result;
    }
}