public class Solution
{
    boolean canBreak[];

    boolean isCal[];

    int LEN;

    Set<String> dict;

    public boolean canBreak(String s, int startIndex)
    {
        if (isCal[startIndex]) return canBreak[startIndex];
        boolean result = false;
        int i = 0;
        int remainingLEN = LEN - startIndex;
        for (String word : dict)
        {
            int n = word.length();
            if (n <= remainingLEN)
            {
                for (i = 0; i < n; i++ )
                {
                    if (word.charAt(i) != s.charAt(i + startIndex))
                    {
                        break;
                    }
                }
                if (i == n)
                {
                    if (n == remainingLEN)
                    {
                        result = true;
                    }
                    else
                    {
                        result = canBreak(s, startIndex + n);
                    }
                }
            }
            if (result)
            {
                break;
            }
        }
        canBreak[startIndex] = result;
        isCal[startIndex] = true;
        return result;
    }

    public boolean wordBreak(String s, Set<String> dict)
    {
        if (s == null || s.length() == 0 || dict.size() == 0) return false;
        LEN = s.length();
        canBreak = new boolean[LEN];
        isCal = new boolean[LEN];
        this.dict = dict;
        for (int i = 0; i < LEN; i++ )
        {
            isCal[i] = false;
        }
        canBreak(s, 0);
        return canBreak[0];
    }
}
