package Trees.BinarySearchTree.ConstructBST;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] num) {
        return conquer(num, 0, num.length - 1);
    }

    private static TreeNode conquer(int[] data, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(data[mid]);
        root.left = conquer(data, low, mid - 1);
        root.right = conquer(data, mid + 1, high);
        return root;
    }
}
