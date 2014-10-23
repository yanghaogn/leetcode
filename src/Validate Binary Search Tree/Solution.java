
class TreeNode
{
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}


public class Solution
{
    public boolean isValidBST(TreeNode root, int min, int max)
    {
        if (root == null)
        {
            return true;
        }
        if (root.val <= min || root.val >= max)
        {
            return false;
        }
        return isValidBST(root.left, min, Math.min(root.val, max))
               && isValidBST(root.right, Math.max(min, root.val), max);
    }

    public boolean isValidBST(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        return isValidBST(root.left, Integer.MIN_VALUE, root.val)
               && isValidBST(root.right, root.val, Integer.MAX_VALUE);
    }
}