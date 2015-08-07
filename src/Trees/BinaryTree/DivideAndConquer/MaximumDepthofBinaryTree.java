package Trees.BinaryTree.DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 8/7/15.
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Divide
        int l = maxDepth(root.left); // the depth of left subtree
        int r = maxDepth(root.right); // the depth of right subtree

        // Conquer
        return Math.max(l, r) + 1;
    }
}
