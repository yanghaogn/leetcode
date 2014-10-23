public class Solution
{
    public String addBinary(String a, String b)
    {
        if (a == null || a == "" || b == null || b == "")
        {
            return "";
        }
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        char[] arrayC = new char[Math.max(arrayA.length, arrayB.length)];
        int i = arrayA.length - 1;
        int j = arrayB.length - 1;
        int k = arrayC.length - 1;
        int carry = 0;
        int sum;
        while (k >= 0)
        {
            sum = carry;
            if (i >= 0)
            {
                sum += arrayA[i-- ] - '0';
            }
            if (j >= 0)
            {
                sum += arrayB[j-- ] - '0';
            }
            if (sum % 2 == 0)
            {
                arrayC[k-- ] = '0';
            }
            else
            {
                arrayC[k-- ] = '1';
            }
            carry = sum >>> 1;
        }
        return (carry > 0 ? "1" : "") + new String(arrayC);
    }
}