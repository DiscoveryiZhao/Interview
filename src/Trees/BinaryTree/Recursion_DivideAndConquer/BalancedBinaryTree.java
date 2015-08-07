package Trees.BinaryTree.Recursion_DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Divide
        int L = maxDepth(root.left); // the maximum depth of left subtree
        int R = maxDepth(root.right); // the maximum depth of right subtree

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
