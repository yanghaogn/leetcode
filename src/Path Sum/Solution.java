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
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        ArrayList<Integer> nodeValue = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int i;
        int currentValue;
        TreeNode p;
        TreeNode left;
        TreeNode right;
        queue.add(root);
        nodeValue.add(root.val);
        for (p = queue.poll(), i = 0; p != null; i++ , p = queue.poll())
        {
            currentValue = nodeValue.get(i);
            left = p.left;
            right = p.right;
            if (left != null)
            {
                queue.add(left);
                nodeValue.add(left.val + currentValue);
            }
            if (right != null)
            {
                queue.add(right);
                nodeValue.add(right.val + currentValue);
            }
            if (left == null && right == null)
            {
                if (currentValue == sum) return true;
            }
        }
        return false;
    }
}