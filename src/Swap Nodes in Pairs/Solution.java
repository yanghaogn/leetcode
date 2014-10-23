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
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode pHead = new ListNode(0);
        ListNode p;
        ListNode first;
        ListNode second;
        ListNode pFirst;
        ListNode pSecond;
        pHead.next = head;
        first = head;
        pFirst = first;
        second = first.next;
        pSecond = first.next;
        for (p = pSecond.next; p != null;)
        {
            pFirst.next = p;
            pFirst = p;
            p = p.next;
            if (p != null)
            {
                pSecond.next = p;
                pSecond = p;
                p = p.next;
            }
            else
            {
                break;
            }
        }
        if (pFirst.next != null)
        {
            pFirst.next = null;
        }
        if (pSecond.next != null)
        {
            pSecond.next = null;
        }
        pFirst = first;
        pSecond = second;
        for (p = pHead; pSecond != null;)
        {
            p.next = pSecond;
            pSecond = pSecond.next;
            p = p.next;
            if (p != null)
            {
                p.next = pFirst;
                pFirst = pFirst.next;
                p = p.next;
            }
        }
        return pHead.next;
    }
}