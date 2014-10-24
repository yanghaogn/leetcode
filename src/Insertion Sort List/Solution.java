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
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = head.next;
        ListNode pNewList;
        pHead.next.next = null;
        while (p != null)
        {
            for (pNewList = pHead; pNewList.next != null; pNewList = pNewList.next)
            {
                if (pNewList.next.val >= p.val) break;
            }
            ListNode next = pNewList.next;
            pNewList.next = p;
            p = p.next;
            pNewList.next.next = next;
        }
        return pHead.next;
    }
}
