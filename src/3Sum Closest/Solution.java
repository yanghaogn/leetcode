public class Solution
{
    public int threeSumClosest(int[] num, int target)
    {
        int result = num[0] + num[1] + num[2];
        int diff = Math.abs(result - target);
        int sum;
        int newDiff;
        int i;
        int j;
        int k;
        Arrays.sort(num);
        for (i = 0; i < num.length - 2; i++ )
        {
            j = i + 1;
            k = num.length - 1;
            while (j < k)
            {
                sum = num[i] + num[j] + num[k];
                newDiff = Math.abs(sum - target);
                if (newDiff < diff)
                {
                    diff = newDiff;
                    result = sum;
                }
                if (sum < target)
                {
                    j++ ;
                }
                else
                {
                    k-- ;
                }
            }
        }
        return result;
    }
}
