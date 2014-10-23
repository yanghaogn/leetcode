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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode last = head;
        int carry = 0;
        int current = 0;
        while (l1 != null || l2 != null || carry > 0)
        {
            current = carry;
            if (l1 != null)
            {
                current += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                current += l2.val;
                l2 = l2.next;
            }
            carry = current / 10;
            current %= 10;
            ListNode p = new ListNode(current);
            last.next = p;
            last = p;
        }
        return head.next;
    }
}