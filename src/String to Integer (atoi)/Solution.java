public class Solution
{
    public int atoi(String str)
    {
        boolean isPositive = true;
        int ERROR = 0;
        if (str == null || str.trim().equals(""))
        {
            return ERROR;
        }
        str = str.trim();
        int index = 0;
        long result = 0;
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        boolean overflow = false;
        boolean isNum = false;
        if (str.charAt(0) == '-')
        {
            index = 1;
            isPositive = false;
        }
        if (str.charAt(0) == '+')
        {
            index = 1;
        }
        for (; index < str.length(); index++ )
        {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9')
            {
                if (overflow)
                {
                    continue;
                }
                isNum = true;
                if (isPositive)
                {
                    result *= 10;
                    result += str.charAt(index) - '0';
                    if (result >= INT_MAX)
                    {
                        overflow = true;
                        result = INT_MAX;
                    }
                }
                if (!isPositive)
                {
                    result *= 10;
                    result -= str.charAt(index) - '0';
                    if (result <= INT_MIN)
                    {
                        overflow = false;
                        result = INT_MIN;
                    }
                }
            }
            else
            {
                break;
            }
        }
        if (!isNum)
        {
            return ERROR;
        }
        return (int)result;
    }
}