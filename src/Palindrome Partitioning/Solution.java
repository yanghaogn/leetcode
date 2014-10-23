public class Solution
{
    ArrayList<List<List<String>>> lists;

    String s;

    public boolean isPalindrome(int start, int end)
    {
        while (end > start)
        {
            if (s.charAt(end) != s.charAt(start))
            {
                return false;
            }
            end-- ;
            start++ ;
        }
        return true;
    }

    public void calPartition(int index)
    {
        List<List<String>> result = lists.get(index);
        for (int end = index; end < s.length(); end++ )
        {
            if (isPalindrome(index, end))
            {
                String pString = s.substring(index, end + 1);
                if (end == s.length() - 1)
                {
                    List<String> p = new LinkedList<String>();
                    p.add(pString);
                    result.add(p);
                    continue;
                }
                List<List<String>> p = lists.get(end + 1);
                for (List<String> tmp : p)
                {
                    List<String> t = new LinkedList<String>();
                    t.addAll(tmp);
                    t.add(0, pString);
                    result.add(t);
                }
            }
        }
    }

    public List<List<String>> partition(String s)
    {
        lists = new ArrayList<List<List<String>>>(s.length());
        this.s = s;
        for (int i = 0; i < s.length(); i++ )
        {
            lists.add(new LinkedList<List<String>>());
        }
        for (int i = s.length() - 1; i >= 0; i-- )
        {
            calPartition(i);
        }
        return lists.get(0);
    }
}