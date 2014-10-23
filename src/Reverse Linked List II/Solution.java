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
    public void reverseBetween(ListNode first, ListNode end)
    {
        if (first == end)
        {
            return;
        }
        ListNode prior = first;
        ListNode p = prior.next;
        for (; p != end;)
        {
            ListNode next = p.next;
            p.next = prior;
            prior = p;
            p = next;
        }
        end.next = prior;
    }

    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || m == n)
        {
            return head;
        }
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode prior = pHead;
        ListNode next;
        ListNode first;
        ListNode end;
        int i = 0;
        for (i = 1; i < m; i++ )
        {
            prior = prior.next;
        }
        first = prior.next;
        for (i = m, end = first; i < n; i++ )
        {
            end = end.next;
        }
        next = end.next;
        reverseBetween(first, end);
        prior.next = end;
        first.next = next;
        return pHead.next;
    }
}