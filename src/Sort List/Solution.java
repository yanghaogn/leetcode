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
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null) return head;
        int LEN = 0;
        ListNode p = head;
        while (p != null)
        {
            LEN++ ;
            p = p.next;
        }
        ListNode pFirstHead, pFirstEnd, pSecondHead;
        int i;
        for (i = 1, pFirstEnd = head; i < LEN / 2; i++ )
            pFirstEnd = pFirstEnd.next;
        pSecondHead = pFirstEnd.next;
        pFirstEnd.next = null;
        pFirstHead = sortList(head);
        pSecondHead = sortList(pSecondHead);
        head = null;
        for (; pFirstHead != null && pSecondHead != null;)
        {
            ListNode smallNode;
            if (pFirstHead.val < pSecondHead.val)
            {
                smallNode = pFirstHead;
                pFirstHead = pFirstHead.next;
            }
            else
            {
                smallNode = pSecondHead;
                pSecondHead = pSecondHead.next;
            }
            smallNode.next = null;
            if (head == null)
            {
                head = smallNode;
                p = head;
            }
            else
            {
                p.next = smallNode;
                p = smallNode;
            }
        }
        if (pFirstHead != null)
            p.next = pFirstHead;
        else
        {
            p.next = pSecondHead;
        }
        return head;
    }
}