public class Solution
{
    int[][] matrix;

    boolean[] equals;

    String S;

    String T;

    int lenS;

    int lenT;

    private int calDistinct(int i, int j)
    {
        if (matrix[i][j] != -1)
        {
            return matrix[i][j];
        }
        if (lenS - i == lenT - j)
        {
            matrix[i][j] = equals[j] ? 1 : 0;
            return matrix[i][j];
        }
        if (lenS - i < lenT - j)
        {
            matrix[i][j] = 0;
            return matrix[i][j];
        }
        matrix[i][j] = 0;
        if (S.charAt(i) == T.charAt(j))
        {
            if (j + 1 == lenT)
            {
                matrix[i][j] += 1;
            }
            else
            {
                matrix[i][j] += calDistinct(i + 1, j + 1);
            }
        }
        for (int p = i + 1; p < lenS; p++ )
        {
            if (S.charAt(p) == T.charAt(j))
            {
                matrix[i][j] += calDistinct(p, j);
                break;
            }
        }
        return matrix[i][j];
    }

    public int numDistinct(String S, String T)
    {
        if (S == null || T == null || S.length() < T.length())
        {
            return 0;
        }
        if (T.length() == 0)
        {
            return 1;
        }
        if (S.length() == 0)
        {
            return 0;
        }
        this.S = S;
        this.T = T;
        this.lenS = S.length();
        this.lenT = T.length();
        matrix = new int[lenS][lenT];
        for (int i = 0; i < lenS; i++ )
        {
            for (int j = 0; j < lenT; j++ )
            {
                matrix[i][j] = -1;
            }
        }
        equals = new boolean[lenT];
        equals[lenT - 1] = S.charAt(lenS - 1) == T.charAt(lenT - 1);
        int p;
        for (p = lenT - 2; p >= 0; p-- )
        {
            equals[p] = equals[p + 1] && S.charAt(lenS - (lenT - p)) == T.charAt(p);
        }
        return calDistinct(0, 0);
    }
}