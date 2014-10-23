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

    public void solve(char[][] board)
    {
        if (board == null || board.length <= 2 || board[0].length <= 2)
        {
            return;
        }
        LinkedList<IntPair> nodes = new LinkedList<IntPair>();
        int ROW = board.length;
        int COL = board[0].length;
        int row;
        int col;
        for (row = 0; row < ROW; row++ )
        {
            if (board[row][0] == 'O')
            {
                board[row][0] = 'B';
                if (board[row][1] == 'O')
                {
                    nodes.add(new IntPair(row, 1));
                }
            }
            if (board[row][COL - 1] == 'O')
            {
                board[row][COL - 1] = 'B';
                if (board[row][COL - 2] == 'O')
                {
                    nodes.add(new IntPair(row, COL - 2));
                }
            }
        }
        for (col = 0; col < COL; col++ )
        {
            if (board[0][col] == 'O')
            {
                board[0][col] = 'B';
                if (board[1][col] == 'O')
                {
                    nodes.add(new IntPair(1, col));
                }
            }
            if (board[ROW - 1][col] == 'O')
            {
                board[ROW - 1][col] = 'B';
                if (board[ROW - 2][col] == 'O')
                {
                    nodes.add(new IntPair(ROW - 2, col));
                }
            }
        }
        while (nodes.size() > 0)
        {
            IntPair pair = nodes.remove(0);
            board[pair.row][pair.col] = 'B';
            if (pair.row > 0 && board[pair.row - 1][pair.col] == 'O')
            {
                nodes.add(new IntPair(pair.row - 1, pair.col));
            }
            if (pair.row < ROW - 1 && board[pair.row + 1][pair.col] == 'O')
            {
                nodes.add(new IntPair(pair.row + 1, pair.col));
            }
            if (pair.col > 0 && board[pair.row][pair.col - 1] == 'O')
            {
                nodes.add(new IntPair(pair.row, pair.col - 1));
            }
            if (pair.col < COL - 1 && board[pair.row][pair.col + 1] == 'O')
            {
                nodes.add(new IntPair(pair.row, pair.col + 1));
            }
        }
        for (row = 0; row < ROW; row++ )
        {
            for (col = 0; col < COL; col++ )
            {
                if (board[row][col] == 'O')
                {

                    board[row][col] = 'X';
                }
                if (board[row][col] == 'B')
                {

                    board[row][col] = 'O';
                }
            }
        }
    }

}