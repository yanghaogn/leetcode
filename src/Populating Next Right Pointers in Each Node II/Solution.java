class TreeLinkNode
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
        TreeLinkNode firstBelow = null;
        TreeLinkNode pBelow = null;
        while (firstUpper != null)
        {
            pUpper = firstUpper;
            while (pUpper != null)
            {
                if (pUpper.left != null)
                {
                    if (firstBelow == null)
                    {
                        firstBelow = pUpper.left;
                        pBelow = firstBelow;
                    }
                    else
                    {
                        pBelow.next = pUpper.left;
                        pBelow = pBelow.next;
                    }
                }
                if (pUpper.right != null)
                {
                    if (firstBelow == null)
                    {
                        firstBelow = pUpper.right;
                        pBelow = firstBelow;
                    }
                    else
                    {
                        pBelow.next = pUpper.right;
                        pBelow = pBelow.next;
                    }
                }
                pUpper = pUpper.next;
            }
            firstUpper = firstBelow;
            firstBelow = null;
        }
    }
}