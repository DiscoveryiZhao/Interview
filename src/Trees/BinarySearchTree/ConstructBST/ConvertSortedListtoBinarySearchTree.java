package Trees.BinarySearchTree.ConstructBST;

import LibraryOfLeetcode.ListNode;
import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class ConvertSortedListtoBinarySearchTree {

    public static ListNode h;

    public TreeNode sortedListToBST(ListNode head) {
        h = head;
        // calculate list length
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        // build the BST
        return conquer(0, n - 1);
    }

    private TreeNode conquer(int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        // build up tree recursively
        TreeNode L = conquer(low, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode R = conquer(mid + 1, high);
        root.left = L;
        root.right = R;
        return root;
    }
}
