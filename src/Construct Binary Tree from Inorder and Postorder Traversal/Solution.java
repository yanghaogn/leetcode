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
    int[] inorder;

    int[] postorder;

    public TreeNode buildTree(int iInorder, int jInorder, int iPostorder, int jPostorder)
    {
        TreeNode head = new TreeNode(postorder[jPostorder]);
        int leftLen = 0;
        for (int i = iInorder; inorder[i] != head.val; i++ )
        {
            leftLen++ ;
        }
        if (leftLen > 0)
        {
            head.left = buildTree(iInorder, iInorder + leftLen - 1, iPostorder, iPostorder
                                                                                + leftLen - 1);
        }
        int rightLen = jInorder - iInorder - leftLen;
        if (rightLen > 0)
        {
            head.right = buildTree(iInorder + leftLen + 1, jInorder, iPostorder + leftLen,
                jPostorder - 1);
        }
        return head;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if (inorder == null || inorder.length == 0)
        {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }
}
