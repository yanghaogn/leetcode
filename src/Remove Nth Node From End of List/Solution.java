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
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null || n <= 0)
        {
            return head;
        }
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode first = pHead;
        ListNode second = pHead;
        for (int i = 0; i < n; i++ , second = second.next);
        for (; second.next != null; first = first.next, second = second.next);
        first.next = first.next.next;
        return pHead.next;
    }
}