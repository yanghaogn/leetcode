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
    public void flatten(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode last = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (right != null)
        {
            stack.push(right);
        }
        if (left != null)
        {
            stack.push(left);
        }
        while (!stack.empty())
        {
            TreeNode p = stack.pop();
            last.left = null;
            last.right = p;
            last = p;
            left = last.left;
            right = last.right;
            if (right != null)
            {
                stack.push(right);
            }
            if (left != null)
            {
                stack.push(left);
            }
        }
    }
}
