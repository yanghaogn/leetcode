public class Solution
{
    public int[] twoSum(int[] numbers, int target)
    {
        int i = 0, j = 1;
        int result[] = {i, j};
        for (i = 0; i < numbers.length; i++ )
        {
            for (j = i + 1; j < numbers.length; j++ )
            {
                if (numbers[i] + numbers[j] == target)
                {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }
}