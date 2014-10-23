public class ListNode
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
    public ListNode partition(ListNode head, int x)
    {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode pLeft = leftHead;
        ListNode pRight = rightHead;
        for (ListNode p = head; p != null; p = p.next)
        {
            if (p.val < x)
            {
                pLeft.next = p;
                pLeft = p;
            }
            else
            {
                pRight.next = p;
                pRight = p;
            }
        }
        pRight.next = null;
        pLeft.next = rightHead.next;
        return leftHead.next;
    }
}