public class Solution
{
    public List<Integer> grayCode(int n)
    {
        List<Integer> result = new LinkedList<Integer>();
        if (n < 0)
        {
            return result;
        }
        result.add(0);
        int N = 1;
        for (int i = 1; i <= n; i++ )
        {
            for (int j = result.size() - 1; j >= 0; j-- )
            {
                result.add(N + result.get(j));
            }
            N = N << 1;
        }
        return result;
    }
}