public class Solution
{
    public static class IntPair
    {
        int row;

        int col;

        IntPair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    List<IntPair> list;

    char[][] board;

    public boolean solve(int index)
    {
        if (index >= list.size())
        {
            return true;
        }
        int row = list.get(index).row;
        int col = list.get(index).col;
        Set<Character> p = new HashSet<Character>(20);
        for (char i = '1'; i <= '9'; i++ )
        {
            p.add(i);
        }
        for (int i = 0; i < 9; i++ )
        {
            if (board[i][col] != '.')
            {
                p.remove(board[i][col]);
            }
            if (board[row][i] != '.')
            {
                p.remove(board[row][i]);
            }
        }
        for (int i = 0; i < 3; i++ )
        {
            for (int j = 0; j < 3; j++ )
            {
                if (board[row / 3 * 3 + i][col / 3 * 3 + j] != '.')
                {
                    p.remove(board[row / 3 * 3 + i][col / 3 * 3 + j]);
                }
            }
        }
        for (char c : p)
        {
            board[row][col] = c;
            if (solve(index + 1))
            {
                return true;
            }

        }
        board[row][col] = '.';
        return false;
    }

    public void solveSudoku(char[][] board)
    {
        int row;
        int col;
        list = new LinkedList<IntPair>();
        this.board = board;
        for (row = 0; row < 9; row++ )
        {
            for (col = 0; col < 9; col++ )
            {
                if (board[row][col] == '.')
                {
                    list.add(new IntPair(row, col));
                }
            }
        }
        solve(0);
    }
}