public class Solution
{
    public int longestValidParentheses(String s)
    {
        if (s == null || s.length() <= 1)
        {
            return 0;
        }
        char[] array = s.toCharArray();
        int i = 0;
        int j = 0;
        int result = 0;
        for (j = 1; j < array.length; j++ )
        {
            if (array[j] == ')')
            {
                if (i >= 0 && array[i] == '(')
                {
                    array[i] = 0;
                    array[j] = 0;
                    while (i >= 0 && array[i] == 0)
                    {
                        i-- ;
                    }
                    result = Math.max(result, j - i);
                    continue;
                }
            }
            i = j;
        }
        return result;
    }
}