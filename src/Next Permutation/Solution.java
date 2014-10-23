public class Solution
{
    public void reverse(int[] num, int i, int j)
    {
        for (; i < j; i++ , j-- )
        {
            int p = num[i];
            num[i] = num[j];
            num[j] = p;
        }
    }

    public void nextPermutation(int[] num)
    {
        if (num == null || num.length <= 1)
        {
            return;
        }
        int i, j;
        for (i = num.length - 2; i >= 0; i-- )
        {
            if (num[i + 1] <= num[i])
            {
                continue;
            }
            for (j = num.length - 1; j > i; j-- )
            {
                if (num[j] > num[i])
                {
                    int p = num[i];
                    num[i] = num[j];
                    num[j] = p;
                    reverse(num, i + 1, num.length - 1);
                    return;
                }
            }
        }
        reverse(num, 0, num.length - 1);
    }
}