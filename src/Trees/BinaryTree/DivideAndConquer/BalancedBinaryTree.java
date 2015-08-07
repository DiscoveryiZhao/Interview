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
        }
        // Divide
        int L = helper(root.left);
        int R = helper(root.right);

        // Conquer
        if (L == -1 || R == -1) {
            return -1;
        }
        if (Math.abs(L - R) > 1) {
            return -1;
        }
        return Math.max(L, R) + 1;
    }
}
