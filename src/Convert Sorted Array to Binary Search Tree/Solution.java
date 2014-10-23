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
    int[] num;

    public TreeNode toBST(int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode result = new TreeNode(num[middle]);
        result.left = toBST(start, middle - 1);
        result.right = toBST(middle + 1, end);
        return result;
    }

    public TreeNode sortedArrayToBST(int[] num)
    {
        if (num == null || num.length == 0)
        {
            return null;
        }
        this.num = num;
        return toBST(0, num.length - 1);
    }
}