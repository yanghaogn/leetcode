public class Solution
{
    public int candy(int[] ratings)
    {
        if (ratings == null || ratings.length == 0)
        {
            return 0;
        }
        int N = ratings.length;
        if (N == 1)
        {
            return 1;
        }
        int[] numCandy = new int[N];
        int[] bottom = new int[N];
        int bottomIndex = -1;
        for (int i = 0; i < N; i++ )
        {
            numCandy[i] = -1;
            if (i == 0)
            {
                if (ratings[0] <= ratings[1])
                {
                    bottom[++bottomIndex] = i;
                    numCandy[i] = 1;
                }
            }
            else
            {
                if (i == N - 1)
                {
                    if (ratings[i] <= ratings[i - 1])
                    {
                        bottom[++bottomIndex] = i;
                        numCandy[i] = 1;
                    }
                }
                else
                {
                    if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
                    {
                        bottom[++bottomIndex] = i;
                        numCandy[i] = 1;
                    }
                }
            }
        }

        int start = -1;
        int end = -1;
        for (int index = 0; index <= bottomIndex; index++ )
        {
            start = end;
            end = bottom[index];
            int p = end - 1;
            while (p > start && numCandy[p] == -1)
            {
                numCandy[p] = numCandy[p + 1] + 1;
                p-- ;
            }
            if (p > 0 && ratings[p] > ratings[p + 1])
            {
                numCandy[p] = Math.max(numCandy[p], numCandy[p + 1] + 1);
            }
            p = end + 1;
            while (p < N && numCandy[p] == -1)
            {
                numCandy[p] = numCandy[p - 1] + 1;
                if (p < N - 1 && ratings[p] >= ratings[p + 1])
                {
                    break;
                }
                p++ ;
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++ )
        {
            result += numCandy[i];
        }
        return result;
    }
}