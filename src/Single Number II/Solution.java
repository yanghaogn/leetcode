public class Solution
{
    public int singleNumber(int[] A, int N)
    {
        int count[] = new int[32];
        int valueOfBit[] = new int[32];
        int resultBit[] = new int[32];
        int i;
        int result = 0;
        count[0] = 0;
        valueOfBit[0] = 1;
        resultBit[0] = 0;
        for (i = 1; i < 32; i++ )
        {
            count[i] = 0;
            valueOfBit[i] = valueOfBit[i - 1] << 1;
            resultBit[i] = 0;

        }
        for (int element : A)
        {
            for (i = 0; i < 32; i++ )
            {
                if ((element & valueOfBit[i]) != 0)
                {
                    resultBit[i]++ ;
                }
            }
        }
        for (i = 0; i < 32; i++ )
        {
            resultBit[i] %= N;
            if (resultBit[i] != 0)
            {
                result += valueOfBit[i];
            }
        }
        return result;
    }

    public int singleNumber(int[] A)
    {
        return singleNumber(A, 3);
    }
}