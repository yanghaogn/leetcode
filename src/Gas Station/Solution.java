public class Solution
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int N = gas.length;
        int capacity = 0;
        int i = 0;
        while (i < N)
        {
            for (; capacity >= 0 && i < N; i++ )
            {
                capacity += gas[i] - cost[i];
            }
            for (; capacity < 0 && i < N; N-- )
            {
                capacity += gas[N - 1] - cost[N - 1];
            }
        }
        if (capacity < 0)
        {
            return -1;
        }
        return N % gas.length;
    }
}