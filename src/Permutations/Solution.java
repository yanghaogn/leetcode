public class Solution
{
    public List<List<Integer>> permute(int[] num, int index)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (index == num.length)
        {
            List<Integer> p = new ArrayList<Integer>(num.length);
            result.add(p);
            return result;
        }
        for (int i = index; i < num.length; i++ )
        {
            int t = num[index];
            num[index] = num[i];
            num[i] = t;
            List<List<Integer>> next = permute(num, index + 1);
            for (List<Integer> p : next)
            {
                p.add(0, num[index]);
            }
            result.addAll(next);
            t = num[index];
            num[index] = num[i];
            num[i] = t;
        }
        return result;
    }

    public List<List<Integer>> permute(int[] num)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num == null || num.length <= 0)
        {
            return result;
        }
        result = permute(num, 0);
        return result;
    }
}