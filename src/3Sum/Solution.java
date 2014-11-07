public class Solution
{
    List<List<Integer>> twoSum(int[] array, int startIndex, int dest)
    {
        int endIndex = array.length - 1;
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

    public List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length < 3)
        {
            return result;
        }
        int[] array = new int[num.length];
        for (int i = 0; i < num.length; i++ )
        {
            array[i] = num[i];
        }
        Arrays.sort(array);
        for (int i = 0; i + 2 < array.length;)
        {
            List<List<Integer>> list = twoSum(array, i + 1, 0 - array[i]);
            for (List<Integer> p : list)
            {
                p.add(0, array[i]);
                result.add(p);
            }
            for (i++ ; i < array.length; i++ )
            {
                if (array[i] != array[i - 1])
                {
                    break;
                }
            }
        }
        return result;
    }
}
