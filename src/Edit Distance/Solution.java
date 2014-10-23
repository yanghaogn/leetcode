public class Solution
{
    int[][] min;

    char[] array1;

    char[] array2;

    int LEN1;

    int LEN2;

    public int calDistance(int index1, int index2)
    {
        if (min[index1][index2] != -1)
        {
            return min[index1][index2];
        }
        if (array1[index1] == array2[index2])
        {
            min[index1][index2] = calDistance(index1 + 1, index2 + 1);
        }
        else
        {
            // add
            min[index1][index2] = calDistance(index1, index2 + 1) + 1;
            // delete
            min[index1][index2] = Math.min(min[index1][index2],
                calDistance(index1 + 1, index2) + 1);
            // change
            min[index1][index2] = Math.min(min[index1][index2],
                calDistance(index1 + 1, index2 + 1) + 1);
        }
        return min[index1][index2];

    }

    public int minDistance(String word1, String word2)
    {
        if (word1.length() > word2.length())
        {
            return minDistance(word2, word1);
        }
        LEN1 = word1.length();
        LEN2 = word2.length();
        if (LEN1 == 0)
        {
            return LEN2;
        }
        array1 = word1.toCharArray();
        array2 = word2.toCharArray();
        min = new int[LEN1][LEN2];
        for (int i = 0; i < LEN1; i++ )
        {
            for (int j = 0; j < LEN2; j++ )
            {
                min[i][j] = -1;
            }
        }
        boolean exists = false;
        for (int i = LEN2 - 1; i >= 0; i-- )
        {
            exists = exists || array1[LEN1 - 1] == array2[i];
            min[LEN1 - 1][i] = LEN2 - i - (exists ? 1 : 0);
        }
        exists = false;
        for (int i = LEN1 - 1; i >= 0; i-- )
        {
            exists = exists || array1[i] == array2[LEN2 - 1];
            min[i][LEN2 - 1] = LEN1 - i - (exists ? 1 : 0);
        }
        return calDistance(0, 0);
    }
}