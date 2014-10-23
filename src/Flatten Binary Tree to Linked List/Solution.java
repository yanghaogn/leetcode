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
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (right != null)
        {
            list.add(0, right);
        }
        if (left != null)
        {
            list.add(0, left);
        }
        while (list.size() > 0)
        {
            TreeNode p = list.get(0);
            list.remove(0);
            last.left = null;
            last.right = p;
            last = p;
            left = last.left;
            right = last.right;
            if (right != null)
            {
                list.add(0, right);
            }
            if (left != null)
            {
                list.add(0, left);
            }
        }
    }
}