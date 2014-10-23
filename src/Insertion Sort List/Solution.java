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
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode newListHead = head;
        ListNode p = head.next;
        ListNode pNewList = newListHead;
        newListHead.next = null;
        for (; p != null;)
        {
            if (p.val < newListHead.val)
            {
                pNewList = p;
                p = p.next;
                pNewList.next = newListHead;
                newListHead = pNewList;
                continue;
            }
            for (pNewList = newListHead; pNewList.next != null; pNewList = pNewList.next)
            {
                if (pNewList.next.val >= p.val) break;
            }
            ListNode pNext = pNewList.next;
            pNewList.next = p;
            p = p.next;
            pNewList.next.next = pNext;
        }
        return newListHead;
    }
}