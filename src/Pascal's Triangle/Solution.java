public class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (numRows < 1)
        {
            return result;
        }
        List<Integer> p = new LinkedList<Integer>();
        p.add(1);
        result.add(p);
        for (int i = 1; i < numRows; i++ )
        {
            p = result.get(i - 1);
            List<Integer> current = new LinkedList<Integer>();
            current.add(1);
            for (int j = 1; j < i; j++ )
            {
                current.add(p.get(j - 1) + p.get(j));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}