public class Solution
{
    int queenPosition[];

    int N;

    List<String[]> resultList;

    StringBuilder line;

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
            for (Integer position : remainingPosition)
            {
                queenPosition[index] = position;
                String[] result = new String[N];
                for (int i = 0; i < N; i++ )
                {
                    line.setCharAt(queenPosition[i], 'Q');
                    result[i] = line.toString();
                    line.setCharAt(queenPosition[i], '.');
                }
                resultList.add(result);
            }
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

    public List<String[]> solveNQueens(int n)
    {
        N = n;
        resultList = new LinkedList<String[]>();
        queenPosition = new int[N];
        line = new StringBuilder(N);
        for (int i = 0; i < N; i++ )
        {
            line.append(".");
        }
        calNQueens(0);
        return resultList;
    }
}