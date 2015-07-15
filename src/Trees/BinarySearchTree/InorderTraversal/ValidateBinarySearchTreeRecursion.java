package Trees.BinarySearchTree.InorderTraversal;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 7/14/15.
 */
public class ValidateBinarySearchTreeRecursion {

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        if (root.val < low || root.val > high) {
            return false;
        }
        return dfs(root.left, low, root.val - 1) && dfs(root.right, root.val + 1, high);
    }
}
