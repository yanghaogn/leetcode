public class Solution
{
    int LEN;

    public List<String> getRemainingString(String s, int position, int index)
    {
        int len = 0;
        List<String> result = new LinkedList<String>();
        String subString;
        if (index == 3)
        {
            subString = s.substring(position);
            int p = Integer.parseInt(subString);
            if (p >= 0 && p <= 255)
            {
                if (!(subString.length() > 1 && subString.startsWith("0")))
                {
                    result.add(subString);
                }
            }
            return result;
        }
        int maxLEN = Math.min(3, LEN - position - (3 - index));
        for (len = 1; len <= maxLEN; len++ )
        {
            subString = s.substring(position, position + len);
            int p = Integer.parseInt(subString);
            if (p >= 0 && p <= 255)
            {
                if (!(subString.length() > 1 && subString.startsWith("0")))
                {
                    result.add(subString);
                }
            }
        }
        return result;
    }

    public List<String> parseIP(String s, int position, int index)
    {
        List<String> result = new LinkedList<String>();
        List<String> p = getRemainingString(s, position, index);
        if (index == 3)
        {
            return p;
        }
        for (String current : p)
        {
            List<String> t = parseIP(s, position + current.length(), index + 1);
            for (String next : t)
            {
                result.add(current + "." + next);
            }
        }
        return result;
    }

    public List<String> restoreIpAddresses(String s)
    {
        if (s == null || s.length() < 4 || s.length() > 12)
        {
            return new LinkedList<String>();
        }
        LEN = s.length();
        return parseIP(s, 0, 0);
    }
}