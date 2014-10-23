class ListNode
{
    int val;

    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}


public class Solution
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null) return false;
        ListNode oneStep = null;
        ListNode twoStep = null;
        for (oneStep = head, twoStep = head; oneStep != null && twoStep != null;)
        {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
            twoStep = (twoStep == null ? null : twoStep.next);
            if (oneStep == twoStep && oneStep != null)
            {
                return true;
            }
        }
        return false;
    }
}