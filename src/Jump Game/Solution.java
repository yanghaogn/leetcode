public class Solution
{
    public boolean canJump(int[] A)
    {
        if (A == null || A.length <= 1)
        {
            return true;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int index = 0; index < A.length - 1; index++ )
        {
            if (A[index] <= 0)
            {
                queue.add(index);
            }
        }

        for (int index = 0; queue.size() > 0 && index < queue.peek();)
        {
            if (A[index] + index > queue.peek())
            {
                queue.remove();
            }
            else
            {
                index++ ;
            }
        }
        return queue.size() == 0;
    }
}