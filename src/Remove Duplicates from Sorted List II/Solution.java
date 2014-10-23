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
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode pHead = new ListNode(0);
        ListNode first;
        ListNode next;
        boolean equals = false;
        pHead.next = head;
        for (first = pHead; first != null;)
        {
            next = first.next;
            equals = false;
            if (next != null)
            {
                next = next.next;
            }
            while (next != null)
            {
                if (next.val == first.next.val)
                {
                    equals = true;
                    next = next.next;
                }
                else
                {
                    break;
                }
            }
            if (equals)
            {
                first.next = next;
            }
            else
            {
                first = first.next;
            }
        }
        return pHead.next;
    }
}