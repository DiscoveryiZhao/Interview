package Trees.BinaryTree.DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            // Divide
            int left = helper(root.left);
            int right = helper(root.right);

            // Conquer
            if (left == -1 || right == -1) {
                return -1;
            }
            if (Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}
