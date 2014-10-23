public class TreeLinkNode
{
    int val;

    TreeLinkNode left, right, next;

    TreeLinkNode(int x)
    {
        val = x;
    }
}


public class Solution
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }
        TreeLinkNode firstUpper = root;
        TreeLinkNode pUpper;
        TreeLinkNode firstBelow;
        TreeLinkNode pBelow;
        while (firstUpper.left != null)
        {
            pUpper = firstUpper;
            pBelow = pUpper.left;
            firstBelow = pBelow;
            while (true)
            {
                pBelow.next = pUpper.right;
                pBelow = pBelow.next;
                pUpper = pUpper.next;
                if (pUpper == null)
                {
                    break;
                }
                pBelow.next = pUpper.left;
                pBelow = pBelow.next;
            }
            firstUpper = firstBelow;
        }
    }
}