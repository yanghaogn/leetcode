public class Solution
{
    public int maxArea(int[] height)
    {
        if (height == null || height.length < 2)
        {
            return 0;
        }
        int N = height.length;
        int[] left = new int[N];
        int[] right = new int[N];
        int max = 0;
        List<Integer> listLeft = new LinkedList<Integer>();
        List<Integer> listRight = new LinkedList<Integer>();
        left[0] = height[0];
        right[N - 1] = height[N - 1];
        listLeft.add(0);
        listRight.add(N - 1);
        for (int i = 1; i < N; i++ )
        {
            if (height[i] > left[i - 1])
            {
                left[i] = height[i];
                listLeft.add(i);
            }
            else
            {
                left[i] = left[i - 1];
            }
        }
        for (int i = N - 2; i >= 0; i-- )
        {
            if (height[i] > right[i + 1])
            {
                right[i] = height[i];
                listRight.add(i);
            }
            else
            {
                right[i] = right[i + 1];
            }
        }
        for (Integer i : listLeft)
        {
            for (Integer j : listRight)
            {
                if (j <= i)
                {
                    break;
                }
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }
}