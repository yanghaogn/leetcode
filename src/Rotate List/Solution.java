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
    public ListNode rotateRight(ListNode head, int n)
    {
        if (n <= 0 || head == null || head.next == null)
        {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        int N = 0;
        for (ListNode p = head; p != null; p = p.next)
        {
            N++ ;
        }
        n = n % N;
        if (n == 0)
        {
            return head;
        }
        while (n >= 2 && second != null)
        {
            second = second.next;
            n-- ;
        }
        if (second == null)
        {
            return head;
        }
        for (; second.next != null; first = first.next, second = second.next);
        second.next = head;
        for (second = head; second != null; second = second.next)
        {
            if (second.next == first)
            {
                second.next = null;
            }
        }
        return first;
    }
}