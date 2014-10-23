public class Solution
{
    public boolean isValid(List<Character> list)
    {
        Set<Character> set = new HashSet<Character>(20);
        for (Character c : list)
        {
            if (c == '.')
            {
                continue;
            }
            if (c < '0' || c > '9')
            {
                return false;
            }
            if (set.contains(c))
            {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board)
    {
        if (board == null)
        {
            return false;
        }
        List<Character> list = new ArrayList<Character>(9);
        int row;
        int col;
        // 行
        for (row = 0; row < 9; row++ )
        {
            list.clear();
            for (col = 0; col < 9; col++ )
            {
                list.add(board[row][col]);
            }
            if (!isValid(list))
            {
                return false;
            }
        }
        // 列
        for (col = 0; col < 9; col++ )
        {
            list.clear();
            for (row = 0; row < 9; row++ )
            {
                list.add(board[row][col]);
            }
            if (!isValid(list))
            {
                return false;
            }
        }
        // 块
        for (int n = 0; n < 9; n++ )
        {
            row = n / 3 * 3;
            col = (n - row) * 3;
            list.clear();
            for (int i = 0; i < 3; i++ )
            {
                for (int j = 0; j < 3; j++ )
                {
                    list.add(board[row + i][col + j]);
                }
            }
            if (!isValid(list))
            {
                return false;
            }
        }
        return true;
    }
}