package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class LowestCommonAncestorofaBinaryTree {
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        } else {
            TreeNode left = lca(root.left, p, q);
            TreeNode right = lca(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }

            return (left == null) ? right : left;
        }
    }
}
