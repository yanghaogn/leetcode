public class Solution
{
    public int jump(int[] A)
    {
        if (A == null || A.length <= 1)
        {
            return 0;
        }
        int[] num = new int[A.length];
        num[A.length - 1] = 0;
        List<Integer> list = new LinkedList<Integer>();
        list.add(A.length - 1);
        for (int i = A.length - 2; i >= 0; i-- )
        {
            int j = 0;
            for (j = 0; j < list.size(); j++ )
            {
                if (i + A[i] >= list.get(j))
                {
                    break;
                }
            }
            if (j == list.size())
            {
                num[i] = Integer.MAX_VALUE;
                continue;
            }
            num[i] = j + 1;
            list.add(j + 1, i);
            if (j + 2 < list.size())
            {
                list.remove(j + 2);
            }
        }
        return num[0];
    }
}