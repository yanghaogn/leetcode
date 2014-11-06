class RandomListNode
{
    int label;

    RandomListNode next, random;

    RandomListNode(int x)
    {
        this.label = x;
    }
};


public class Solution
{
    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
        {
            return null;
        }
        RandomListNode p = head;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode result = null;
        for (p = head; p != null; p = next.next)
        {
            next = new RandomListNode(p.label);
            next.next = p.next;
            p.next = next;
        }
        for (p = head; p != null; p = next.next)
        {
            next = p.next;
            random = p.random;
            next.random = (random == null ? null : random.next);
        }
        for (; head != null; head = p.next)
        {
            next = head.next;
            if (result == null)
            {
                result = next;
            }
            else
            {
                p.next = next;
            }
            p = next;
            head.next = p.next;
        }
        return result;
    }
}
