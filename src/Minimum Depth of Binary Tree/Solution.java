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
    public int minDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int result = 1;
        List<TreeNode> up = new LinkedList<TreeNode>();
        List<TreeNode> down = new LinkedList<TreeNode>();
        up.add(root);
        while (up.size() > 0)
        {
            for (TreeNode node : up)
            {
                if (node.left == null && node.right == null)
                {
                    return result;
                }
                if (node.left != null)
                {
                    down.add(node.left);
                }
                if (node.right != null)
                {
                    down.add(node.right);
                }
            }
            List<TreeNode> p = up;
            up = down;
            down = p;
            down.clear();
            result++ ;
        }
        return result;
    }
}