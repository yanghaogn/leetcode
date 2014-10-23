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
    int[] preorder;

    int[] inorder;

    public TreeNode buildTree(int iPreorder, int jPreorder, int iInorder, int jInorder)
    {
        TreeNode head = new TreeNode(preorder[iPreorder]);
        int leftLen = 0;
        for (int i = iInorder; inorder[i] != head.val; i++ )
        {
            leftLen++ ;
        }
        if (leftLen > 0)
        {
            head.left = buildTree(iPreorder + 1, iPreorder + leftLen, iInorder, iInorder + leftLen
                                                                                - 1);
        }
        int rightLen = jPreorder - iPreorder - leftLen;
        if (rightLen > 0)
        {
            head.right = buildTree(iPreorder + leftLen + 1, jPreorder, iInorder + leftLen + 1,
                jInorder);
        }
        return head;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder == null || preorder.length == 0)
        {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }
}