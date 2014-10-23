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
        ListNode first;
        ListNode next;
        for (first = head; first != null; first = first.next)
        {
            next = first.next;
            while (next != null)
            {
                if (next.val != first.val)
                {
                    break;
                }
                next = next.next;
            }
            first.next = next;
        }
        return head;
    }
}