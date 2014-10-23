public class Solution
{
    char[][] matrix;

    int ROW;

    int COL;

    public static class Node
    {
        int row;

        int col;

        Node(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    public boolean canAddRow(int row, int col, Node node)
    {
        if (node.row == ROW - 1)
        {
            return false;
        }
        for (; col <= node.col; col++ )
        {
            if (matrix[node.row + 1][col] == '0')
            {
                return false;
            }
        }
        return true;
    }

    public boolean canAddCol(int row, int col, Node node)
    {
        if (node.col == COL - 1)
        {
            return false;
        }
        for (; row <= node.row; row++ )
        {
            if (matrix[row][node.col + 1] == '0')
            {
                return false;
            }
        }
        return true;
    }

    public boolean isAllOne(int startRow, int endRow, int startCol, int endCol)
    {
        for (int row = startRow; row <= endRow; row++ )
        {
            for (int col = startCol; col <= endCol; col++ )
            {
                if (matrix[row][col] != '1')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int maximalRectangle(char[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return 0;
        }
        ROW = matrix.length;
        COL = matrix[0].length;
        this.matrix = matrix;
        int area = 0;
        Node[][] square = new Node[ROW][COL];
        for (int row = 0; row < ROW; row++ )
        {
            for (int col = 0; col < COL; col++ )
            {
                square[row][col] = new Node(row, col);
            }
        }
        for (int row = 0; row < ROW; row++ )
        {
            for (int col = 0; col < COL; col++ )
            {
                if (matrix[row][col] == '1')
                {
                    if (row > 0)
                    {
                        square[row][col].row = Math.max(square[row][col].row,
                            square[row - 1][col].row);
                        square[row][col].col = Math.max(square[row][col].col,
                            square[row - 1][col].col - 1);
                    }
                    if (col > 0)
                    {
                        square[row][col].row = Math.max(square[row][col].row,
                            square[row][col - 1].row - 1);
                        square[row][col].col = Math.max(square[row][col].col,
                            square[row][col - 1].col);
                        if (row > 0)
                        {
                            square[row][col].row = Math.max(square[row][col].row,
                                square[row - 1][col - 1].row);
                            square[row][col].col = Math.max(square[row][col].col,
                                square[row - 1][col - 1].col);
                        }
                    }
                    while (canAddRow(row, col, square[row][col])
                           && canAddCol(row, col, square[row][col])
                           && (matrix[square[row][col].row + 1][square[row][col].col + 1] == '1'))
                    {
                        square[row][col].row++ ;
                        square[row][col].col++ ;
                    }
                    // System.out.println(row+"\t"+col+":"+square[row][col].row+"\t"+square[row][col].col);
                }
            }
        }
        for (int row = 0; row < ROW; row++ )
        {
            for (int col = 0; col < COL; col++ )
            {
                if (matrix[row][col] == '1')
                {
                    int minRow = row;
                    int maxRow = square[row][col].row;
                    for (; minRow > 0; minRow-- )
                    {
                        if (!isAllOne(minRow - 1, minRow - 1, col, square[row][col].col))
                        {
                            break;
                        }
                    }
                    for (; maxRow < ROW - 1; maxRow++ )
                    {
                        if (!isAllOne(maxRow + 1, maxRow + 1, col, square[row][col].col))
                        {
                            break;
                        }
                    }
                    int minCol = col;
                    int maxCol = square[row][col].col;
                    for (; minCol > 0; minCol-- )
                    {
                        if (!isAllOne(row, square[row][col].row, minCol - 1, col))
                        {
                            break;
                        }
                    }
                    for (; maxCol < COL - 1; maxCol++ )
                    {
                        if (!isAllOne(row, square[row][col].row, col, maxCol + 1))
                        {
                            break;
                        }
                    }

                    area = Math.max(area, (maxRow - minRow + 1) * (square[row][col].col - col + 1));
                    area = Math.max(area, (square[row][col].row - row + 1) * (maxCol - minCol + 1));
                }
            }
        }
        return area;
    }
}