public class Solution
{
    public int[] plusOne(int[] digits)
    {
        int carry = 1;
        int sum = 0;
        int N = 0;
        if (digits != null)
        {
            N = digits.length;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = N - 1; i >= 0; i-- )
        {
            sum = digits[i] + carry;
            carry = sum / 10;
            list.add(0, sum - 10 * carry);
        }
        if (carry > 0)
        {
            list.add(0, carry);
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < result.length; i++ )
        {
            result[i] = list.get(i);
        }
        return result;
    }
}