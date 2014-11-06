public class Solution
{
    public boolean isPalindrome(String s)
    {
        if (s == null || s.length() <= 1)
        {
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        char start = 0;
        char end = 0;
        while (i < j)
        {
            while (i < j)
            {
                start = s.charAt(i);
                if ((start >= '0' && start <= '9') || ((start >= 'a') && (start <= 'z'))) break;
                i++ ;
            }
            while (i < j)
            {

                end = s.charAt(j);
                if ((end >= '0' && end <= '9') || ((end >= 'a') && (end <= 'z'))) break;
                j-- ;
            }
            if (i < j && start != end)
            {
                return false;
            }
            i++ ;
            j-- ;
        }
        return true;
    }
}
