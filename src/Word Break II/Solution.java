public class Solution
{
    boolean isCal[];

    ArrayList<LinkedList<String>> listResult;

    int LEN;

    Set<String> dict;

    public LinkedList<String> calBreak(String s, int startIndex)
    {
        LinkedList<String> result = listResult.get(startIndex);
        if (isCal[startIndex]) return result;
        int i = 0;
        final int remaingLEN = LEN - startIndex;
        LinkedList<String> p = null;
        for (String word : dict)
        {
            int n = word.length();
            if (n <= remaingLEN)
            {
                for (i = 0; (i < n) && (word.charAt(i) == s.charAt(i + startIndex)); i++ )
                {}
                if (i == n)
                {
                    if (n == remaingLEN)
                    {
                        result.add(word);
                    }
                    else
                    {
                        p = calBreak(s, startIndex + n);
                        for (String element : p)
                        {
                            result.add(word + " " + element);
                        }
                    }
                }
            }
        }
        isCal[startIndex] = true;
        return result;
    }

    public List<String> wordBreak(String s, Set<String> dict)
    {
        if (s == null) return null;
        LEN = s.length();
        isCal = new boolean[LEN];
        listResult = new ArrayList<LinkedList<String>>(LEN);
        if (LEN == 0 || dict.size() == 0)
        {
            return new LinkedList<String>();
        }
        this.dict = dict;
        for (int i = 0; i < LEN; i++ )
        {
            isCal[i] = false;
            listResult.add(new LinkedList<String>());
        }
        calBreak(s, 0);
        return listResult.get(0);
    }
}