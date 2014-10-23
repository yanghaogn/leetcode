public class Solution
{
    public List<String> generateParenthesis(int n)
    {
        List<String> list = new LinkedList<String>();
        if (n == 0)
        {
            return list;
        }
        List<List<String>> lists = new ArrayList<List<String>>(n + 1);
        lists.add(list);
        list = new LinkedList<String>();
        list.add("()");
        lists.add(list);
        for (int i = 2; i <= n; i++ )
        {
            list = new LinkedList<String>();
            for (String element : lists.get(i - 1))
            {
                list.add("()" + element);
                list.add("(" + element + ")");
            }
            for (int j = 2; j < i; j++ )
            {
                for (String pLeft : lists.get(j - 1))
                {
                    for (String pRight : lists.get(i - j))
                    {
                        list.add("(" + pLeft + ")" + pRight);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(n);
    }
}