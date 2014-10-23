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
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = null;
        if (root == null)
        {
            result = new LinkedList<Integer>();
            return result;
        }
        if (root.left == null && root.right == null)
        {
            result = new LinkedList<Integer>();
            result.add(root.val);
            return result;
        }

        if (root.left != null)
        {
            result = inorderTraversal(root.left);
            result.add(root.val);
        }
        else
        {
            result = new LinkedList<Integer>();
            result.add(root.val);
        }
        if (root.right != null)
        {
            List<Integer> right = inorderTraversal(root.right);
            result.addAll(right);
        }
        return result;
    }
}