package Trees.BinaryTree.Recursion_DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class LowestCommonAncestorofaBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // Divide
        TreeNode l = lowestCommonAncestor(root.left, p, q); // Lowest Common Ancestor of left subtree
        TreeNode r = lowestCommonAncestor(root.right, p, q); // Lowest Common Ancestor of right subtree

        // Conquer
        if (l != null && r != null) {
            return root;
        }
        if (l != null) {
            return l;
        }
        if (r != null) {
            return r;
        }
        return null;
    }
}
