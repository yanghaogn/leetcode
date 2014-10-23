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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode p;
        for (p = head; l1 != null && l2 != null; p = p.next)
        {
            if (l1.val < l2.val)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null)
        {
            p.next = l2;
        }
        else
        {
            p.next = l1;
        }
        return head.next;
    }

    public ListNode mergeKLists(List<ListNode> lists)
    {
        if (lists == null || lists.size() == 0)
        {
            return null;
        }
        LinkedList<ListNode> p = new LinkedList<ListNode>();
        p.addAll(lists);
        while (p.size() > 1)
        {
            ListNode first = p.poll();
            ListNode second = p.poll();
            p.add(mergeTwoLists(first, second));
        }
        return p.get(0);
    }
}