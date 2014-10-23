public class Solution
{
    int minLEN = Integer.MAX_VALUE;

    public String longestCommonPrefix(List<String> strs)
    {
        if (minLEN == 0)
        {
            return "";
        }
        int LEN = strs.size();
        if (LEN == 1)
        {
            return strs.get(0);
        }
        List<String> prefix = new LinkedList<String>();
        int index = 0;
        StringBuilder builder = new StringBuilder("");
        for (index = 1; index < LEN; index += 2)
        {
            builder.delete(0, builder.length());
            String a = strs.get(index);
            String b = strs.get(index - 1);
            minLEN = Math.min(a.length(), minLEN);
            minLEN = Math.min(b.length(), minLEN);
            for (int i = 0; i < minLEN; i++ )
            {
                if (a.charAt(i) == b.charAt(i))
                {
                    builder.append(a.charAt(i));
                    continue;
                }
                break;
            }
            prefix.add(builder.toString());
        }
        if (index == LEN)
        {
            prefix.add(strs.get(index - 1));
        }
        return longestCommonPrefix(prefix);
    }

    public String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        List<String> list = new LinkedList<String>();
        for (String s : strs)
        {
            list.add(s);
        }
        return longestCommonPrefix(list);
    }
}