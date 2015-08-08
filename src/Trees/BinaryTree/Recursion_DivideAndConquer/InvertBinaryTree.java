package Trees.BinaryTree.Recursion_DivideAndConquer;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Divide
        TreeNode L = invertTree(root.left); // left subtree
        TreeNode R = invertTree(root.right); // right subtree

        // Conquer
        root.left = R;
        root.right = L;
        return root;
    }
}
