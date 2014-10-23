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
    int result = Integer.MIN_VALUE;

    int calNode(TreeNode root)
    {
        int left = root.val;
        int right = root.val;
        if (root.left != null)
        {
            left += calNode(root.left);
        }
        if (root.right != null)
        {
            right += calNode(root.right);
        }
        left = Math.max(left, root.val);
        right = Math.max(right, root.val);
        result = Math.max(result, left + right - root.val);
        return Math.max(left, right);
    }

    public int maxPathSum(TreeNode root)
    {
        calNode(root);
        return result;
    }
}