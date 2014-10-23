public class Solution
{
    public String minWindow(String S, String T)
    {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length())
        {
            return "";
        }
        List<Integer> list = new LinkedList<Integer>();
        int start = 0;
        int end = S.length() - 1;
        int remaining = T.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>(500);
        for (char c : T.toCharArray())
        {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for (int index = 0; index < S.length(); index++ )
        {
            char c = S.charAt(index);
            if (!map.containsKey(c))
            {
                continue;
            }
            int n = map.get(c);
            if (n > 0)
            {
                remaining-- ;
            }
            map.put(c, map.get(c) - 1);
            list.add(index);
            c = S.charAt(list.get(0));
            while (map.get(c) < 0)
            {
                map.put(c, map.get(c) + 1);
                list.remove(0);
                c = S.charAt(list.get(0));
            }
            if (remaining == 0)
            {
                int pStart = list.get(0);
                int pEnd = list.get(list.size() - 1);
                if (pEnd - pStart < end - start)
                {
                    start = pStart;
                    end = pEnd;
                }
            }
        }
        return remaining == 0 ? S.substring(start, end + 1) : "";
    }
}