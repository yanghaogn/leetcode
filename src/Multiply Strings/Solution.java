public class Solution
{
    public String multiply(String num1, String num2)
    {
        if (num1.length() < num2.length())
        {
            return multiply(num2, num1);
        }
        List<Integer> p;
        List<Integer> result;
        p = new ArrayList<Integer>(num1.length() + num2.length());
        result = new ArrayList<Integer>(num1.length() + num2.length());
        result.add(0);
        for (int i = num1.length() - 1; i >= 0; i-- )
        {
            p.add(Integer.parseInt(num1.substring(i, i + 1)));
        }
        for (int i = num2.length() - 1; i >= 0; i-- )
        {
            int times = Integer.parseInt(num2.substring(i, i + 1));
            if (times > 0)
            {
                int pIndex = 0;
                int rIndex = 0;
                int carry = 0;
                for (; rIndex < result.size(); pIndex++ , rIndex++ )
                {
                    int num = result.get(rIndex) + times * p.get(pIndex) + carry;
                    carry = num / 10;
                    result.set(rIndex, num % 10);
                }
                for (; pIndex < p.size(); pIndex++ )
                {
                    int num = times * p.get(pIndex) + carry;
                    carry = num / 10;
                    result.add(num % 10);
                }
                if (carry > 0)
                {
                    result.add(carry);
                }
            }
            p.add(0, 0);
        }
        StringBuilder builder = new StringBuilder(result.size());
        for (int i = result.size() - 1; i >= 0; i-- )
        {
            builder.append(result.get(i));
        }
        return builder.toString();
    }
}