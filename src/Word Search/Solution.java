public class Solution
{
    boolean[][] visit;

    char[][] board;

    int ROW;

    int COL;

    public boolean exist(int row, int col, String word)
    {
        if (board[row][col] != word.charAt(0))
        {
            return false;
        }
        if (word.length() == 1)
        {
            return true;
        }
        boolean result = false;
        visit[row][col] = true;
        String remaining = word.substring(1);
        if (row > 0 && !visit[row - 1][col])
        {
            result = exist(row - 1, col, remaining);
        }
        if (!result && row < ROW - 1 && !visit[row + 1][col])
        {
            result = exist(row + 1, col, remaining);
        }
        if (!result && col > 0 && !visit[row][col - 1])
        {
            result = exist(row, col - 1, remaining);
        }
        if (!result && col < COL - 1 && !visit[row][col + 1])
        {
            result = exist(row, col + 1, remaining);
        }
        visit[row][col] = false;
        return result;

    }

    public boolean exist(char[][] board, String word)
    {
        if (word == null || word.length() == 0)
        {
            return true;
        }
        if (board == null)
        {
            return false;
        }
        this.board = board;
        ROW = board.length;
        COL = board[0].length;
        visit = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++ )
        {
            for (int j = 0; j < COL; j++ )
            {
                visit[i][j] = false;
            }
        }
        for (int i = 0; i < ROW; i++ )
        {
            for (int j = 0; j < COL; j++ )
            {
                if (exist(i, j, word))
                {
                    return true;
                }
            }
        }
        return false;
    }
}