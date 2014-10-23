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
    public ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode i = head;
        ListNode j = i.next;
        ListNode k = j.next;
        head.next = null;
        for (; k != null; i = j, j = k, k = k.next)
        {
            j.next = i;
        }
        j.next = i;
        return j;
    }

    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null || head.next.next == null)
        {
            return;
        }
        int LEN = 0;
        ListNode p;
        ListNode first = null;
        ListNode second = null;
        ListNode pFirst = null;
        ListNode pSecond = null;
        for (p = head; p != null; p = p.next)
        {
            LEN++ ;
        }
        LEN = LEN / 2;
        for (p = head; LEN > 1; LEN-- )
        {
            p = p.next;
        }
        second = reverse(p.next);
        p.next = null;
        for (first = head; first != null && second != null; first = pFirst, second = pSecond)
        {
            pFirst = first.next;
            pSecond = second.next;
            first.next = second;
            if (pFirst != null)
            {
                second.next = pFirst;
            }
        }
    }
}