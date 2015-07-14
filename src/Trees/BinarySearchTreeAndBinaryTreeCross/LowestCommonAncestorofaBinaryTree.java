package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class LowestCommonAncestorofaBinaryTree {

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // Divide
        TreeNode L = lca(root.left, p, q);
        TreeNode R = lca(root.right, p, q);

        // Conquer
        if (L != null && R != null) {
            return root;
        }

        return (L == null) ? R : L;
    }
}
