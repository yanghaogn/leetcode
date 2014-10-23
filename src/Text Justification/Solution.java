public class Solution
{
    public List<String> fullJustify(String[] words, int L)
    {
        List<String> result = new LinkedList<String>();
        if (words == null || words.length < 1)
        {
            return result;
        }
        int i, j;
        for (i = 0, j = 0; i < words.length; i = j)
        {
            int wordsLen = 0;
            while (j < words.length)
            {
                wordsLen += words[j].length();
                if (wordsLen + j - i > L)
                {
                    break;
                }
                j++ ;
            }
            if (j < words.length)
            {
                wordsLen -= words[j].length();
            }
            String s = "";
            if (j - i == 1)
            {
                s = words[i];

            }
            else
            {
                int p = (j == words.length) ? 1 : (L - wordsLen) / (j - i - 1);
                int remaining = (j == words.length) ? 0 : L - wordsLen - p * (j - i - 1);
                String space = "";
                while (p-- > 0)
                {
                    space += " ";
                }
                for (int k = i; k < j - 1; k++ )
                {
                    s += words[k] + space;
                    if (remaining > 0)
                    {
                        remaining-- ;
                        s += " ";
                    }
                }
                s += words[j - 1];
            }
            while (s.length() < L)
            {
                s += " ";
            }
            result.add(s);
        }
        return result;
    }
}