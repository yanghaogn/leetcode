public class Solution
{
    int queenPosition[];

    int N;

    int totalNum;

    Set<Integer> getRemainingPosition(int index)
    {
        Set<Integer> result = new HashSet<Integer>();
        int i, j;
        for (i = 0; i < N; i++ )
        {
            result.add(i);
        }
        for (i = 0; i < N; i++ )
        {
            for (j = 0; j < index; j++ )
            {
                if ((i == queenPosition[j])
                    || (Math.abs(i - queenPosition[j]) == Math.abs(index - j)))
                {
                    result.remove(i);
                    break;
                }
            }
        }
        return result;
    }

    public void calNQueens(int index)
    {
        Set<Integer> remainingPosition = getRemainingPosition(index);
        if (index + 1 == N)
        {
            totalNum += remainingPosition.size();
        }
        else
        {
            for (Integer position : remainingPosition)
            {
                queenPosition[index] = position;
                calNQueens(index + 1);
            }
        }
    }

    public int totalNQueens(int n)
    {
        N = n;
        totalNum = 0;
        queenPosition = new int[N];
        calNQueens(0);
        return totalNum;
    }
}