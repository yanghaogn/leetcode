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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
        {
            return result;
        }
        List<TreeNode> first = new LinkedList<TreeNode>();
        List<TreeNode> second = new LinkedList<TreeNode>();
        boolean sequence = true;
        first.add(root);
        while (first.size() > 0)
        {
            LinkedList<Integer> currentLevel = new LinkedList<Integer>();
            for (TreeNode node : first)
            {
                if (sequence)
                {
                    currentLevel.add(node.val);
                }
                else
                {
                    currentLevel.add(0, node.val);
                }
                if (node.left != null)
                {
                    second.add(node.left);
                }
                if (node.right != null)
                {
                    second.add(node.right);
                }
            }
            result.add(currentLevel);
            List<TreeNode> tmp = first;
            first = second;
            second = tmp;
            second.clear();
            sequence = !sequence;
        }
        return result;
    }
}