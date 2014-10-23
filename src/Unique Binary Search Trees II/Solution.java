class TreeNode
{
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x)
    {
        val = x;
        left = null;
        right = null;
    }
}


public class Solution
{
    public TreeNode copyNode(TreeNode node)
    {
        if (node == null)
        {
            return null;
        }
        TreeNode nodeCopy = new TreeNode(node.val);
        List<TreeNode> listOriginal = new LinkedList<TreeNode>();
        List<TreeNode> listCopy = new LinkedList<TreeNode>();
        listOriginal.add(node);
        listCopy.add(nodeCopy);
        while (listOriginal.size() > 0)
        {
            TreeNode original = listOriginal.get(0);
            TreeNode copy = listCopy.get(0);
            if (original.left != null)
            {
                copy.left = new TreeNode(original.left.val);
                listOriginal.add(original.left);
                listCopy.add(copy.left);
            }
            if (original.right != null)
            {
                copy.right = new TreeNode(original.right.val);
                listOriginal.add(original.right);
                listCopy.add(copy.right);
            }
            listOriginal.remove(0);
            listCopy.remove(0);
        }
        return nodeCopy;
    }

    public List<TreeNode> generateTrees(int start, int end)
    {
        List<TreeNode> result = new LinkedList<TreeNode>();
        TreeNode root = null;
        if (start > end)
        {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++ )
        {

            List<TreeNode> listLeft = generateTrees(start, i - 1);
            List<TreeNode> listRight = generateTrees(i + 1, end);
            for (TreeNode left : listLeft)
            {
                for (TreeNode right : listRight)
                {
                    root = new TreeNode(i);
                    root.left = copyNode(left);
                    root.right = copyNode(right);
                    result.add(root);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n)
    {
        if (n < 0)
        {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }
}