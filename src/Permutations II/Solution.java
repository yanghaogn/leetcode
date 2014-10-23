public class Solution
{
    public List<Integer> toList(int[] num)
    {
        List<Integer> p = new ArrayList<Integer>(num.length);
        for (int element : num)
        {
            p.add(element);
        }
        return p;
    }

    public void swap(int[] num, int i, int j)
    {
        int p = num[i];
        num[i] = num[j];
        num[j] = p;
    }

    public List<List<Integer>> permuteUnique(int[] num)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length <= 0)
        {
            return result;
        }
        Arrays.sort(num);

        result.add(toList(num));
        int i;
        int j;
        while (true)
        {
            for (i = num.length - 1; i > 0; i-- )
            {
                if (num[i] > num[i - 1])
                {
                    break;
                }
            }
            if (i == 0)
            {
                break;
            }
            for (j = num.length - 1; j > 0; j-- )
            {
                if (num[j] > num[i - 1])
                {
                    break;
                }
            }
            swap(num, i - 1, j);
            j = num.length - 1;
            while (i < j)
            {
                swap(num, i, j);
                i++ ;
                j-- ;
            }
            result.add(toList(num));
        }
        return result;
    }
}