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
    final HashMap<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();

    public LinkedList<Integer> getRootToNodePath(TreeNode node)
    {
        LinkedList<Integer> result;
        if (parent.get(node) == null)
        {
            result = new LinkedList<Integer>();
            result.add(node.val);
            return result;
        }
        result = getRootToNodePath(parent.get(node));
        result.add(node.val);
        return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        ArrayList<Integer> pathValue = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int i;
        int currentValue;
        TreeNode p;
        TreeNode left;
        TreeNode right;
        queue.add(root);
        pathValue.add(root.val);
        parent.put(root, null);
        for (p = queue.poll(), i = 0; p != null; i++ , p = queue.poll())
        {
            currentValue = pathValue.get(i);
            left = p.left;
            right = p.right;
            if (left != null)
            {
                queue.add(left);
                pathValue.add(left.val + currentValue);
                parent.put(left, p);
            }
            if (right != null)
            {
                queue.add(right);
                pathValue.add(right.val + currentValue);
                parent.put(right, p);
            }
            if (left == null && right == null)
            {
                if (currentValue == sum)
                {
                    result.add(getRootToNodePath(p));
                }
            }
        }
        return result;
    }
}