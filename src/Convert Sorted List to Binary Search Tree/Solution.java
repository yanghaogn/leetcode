class ListNode
{
    int val;

    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}


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
    int[] array;

    public TreeNode sortListToBST(int start, int end)
    {
        int middle = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(array[middle]);
        if (middle > start)
        {
            root.left = sortListToBST(start, middle - 1);
        }
        if (middle < end)
        {
            root.right = sortListToBST(middle + 1, end);
        }
        return root;
    }

    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        array = new int[65535];
        int N = 0;
        while (head != null)
        {
            array[N++ ] = head.val;
            head = head.next;
        }
        return sortListToBST(0, N - 1);
    }
}