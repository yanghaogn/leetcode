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

    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next == null) return null;
        ListNode oneStep = null;
        ListNode twoStep = null;
        for (oneStep = head, twoStep = head; oneStep != null && twoStep != null;)
        {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
            twoStep = (twoStep == null ? null : twoStep.next);
            if (oneStep == twoStep && oneStep != null)
            {
                for (oneStep = head; oneStep != twoStep;)
                {
                    oneStep = oneStep.next;
                    twoStep = twoStep.next;
                }
                return twoStep;
            }
        }
        return null;
    }
}