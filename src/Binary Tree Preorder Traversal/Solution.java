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
    public List<Integer> preorderTraversal(TreeNode root)
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
            result = preorderTraversal(root.left);
        }
        if (root.right != null)
        {
            List<Integer> right = preorderTraversal(root.right);
            if (result == null)
            {
                result = right;
            }
            else
            {
                result.addAll(right);
            }
        }
        result.add(0, root.val);
        return result;
    }
}