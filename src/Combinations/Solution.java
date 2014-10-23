public class Solution
{
    public List<List<Integer>> combine(int n, int start, int k)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (k == 0)
        {
            result.add(new LinkedList<Integer>());
            return result;
        }
        for (; start <= n - k + 1; start++ )
        {
            List<List<Integer>> p = combine(n, start + 1, k - 1);
            for (List<Integer> element : p)
            {
                element.add(0, start);
                result.add(element);
            }
        }
        return result;
    }

    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> result = combine(n, 1, k);
        return result;
    }
}