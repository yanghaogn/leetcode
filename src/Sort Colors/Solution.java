public class Solution
{
    public void sortColors(int[] A)
    {
        int i = -1;
        int j = A.length;
        int middle = 0;
        while (middle < j)
        {
            if (A[middle] == 0)
            {
                i++ ;
                middle++ ;
                A[i] = 0;
            }
            else
            {
                if (A[middle] == 1)
                {
                    middle++ ;
                }
                else
                {
                    j-- ;
                    while (middle < j && A[j] == 2)
                    {
                        j-- ;
                    }
                    int t = A[j];
                    A[j] = A[middle];
                    A[middle] = t;
                }
            }
        }
        for (middle = i + 1; middle < j; middle++ )
        {
            A[middle] = 1;
        }
    }
}