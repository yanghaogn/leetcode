public class Solution
{
    public String getPermutation(int n, int k)
    {
        if (n <= 0 || k <= 0)
        {
            return "";
        }
        List<Integer> list = new LinkedList<Integer>();
        int times = 1;
        int index;
        String result = "";
        for (int i = 1; i <= n; i++ )
        {
            list.add(i);
            times *= i;
        }
        while (list.size() > 0)
        {
            times /= list.size();
            index = (k - 1) / times;
            k -= index * times;
            if (index == list.size())
            {
                return "";
            }
            result += list.get(index);
            list.remove(index);
        }
        return result;
    }
}