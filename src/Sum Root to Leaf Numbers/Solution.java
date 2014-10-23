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
    public int sumNumbers(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        LinkedList<TreeNode> listNode = new LinkedList<TreeNode>();
        LinkedList<Integer> partialValue = new LinkedList<Integer>();
        int result = 0;
        listNode.add(root);
        partialValue.add(root.val);
        while (listNode.size() > 0)
        {
            TreeNode node = listNode.poll();
            int value = partialValue.poll();
            if (node.left == null && node.right == null)
            {
                result += value;
                continue;
            }
            if (node.left != null)
            {
                listNode.add(node.left);
                partialValue.add(value * 10 + node.left.val);
            }
            if (node.right != null)
            {
                listNode.add(node.right);
                partialValue.add(value * 10 + node.right.val);
            }
        }
        return result;
    }
}