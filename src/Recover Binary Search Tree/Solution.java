/*
 * 1. 这题的要点就是想到使用树的递归中序遍历，因为二叉查找树合法的情况，中序遍历的值是从小到大排列的。
 * 2. 当出现当前值比前一个值小的时候，就是存在不合法的节点。
 * 3. 用pre存中序遍历时当前节点的前一个节点，方便值的大小对比，用s1，s2记录这两个不合法序列的位置，s1存较大的值，s2存较小的值。
 * 4. 最后把两个不合法的值交换。
 */
class TreeNode
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
    TreeNode mistake1 = null;

    TreeNode mistake2 = null;

    TreeNode pre = null;

    public void recover(TreeNode root)
    {
        if (root != null)
        {
            recover(root.left);
            if (pre != null && pre.val > root.val)
            {
                if (mistake1 == null)
                {
                    mistake1 = pre;
                }
                mistake2 = root;
            }
            pre = root;
            recover(root.right);
        }
    }

    public void recoverTree(TreeNode root)
    {
        recover(root);
        if (mistake1 != null)
        {
            int p = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = p;
        }
    }
}