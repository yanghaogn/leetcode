public class TreeNode
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
    boolean result = true;

    int calHeight(TreeNode root)
    {
        if (!result)
        {
            return 0;
        }
        int left = 1;
        int right = 1;
        if (root.left != null)
        {
            left += calHeight(root.left);
        }
        if (root.right != null)
        {
            right += calHeight(root.right);
        }
        if (left > right + 1 || right > left + 1)
        {
            result = false;
        }
        return Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        calHeight(root);
        return result;
    }
}