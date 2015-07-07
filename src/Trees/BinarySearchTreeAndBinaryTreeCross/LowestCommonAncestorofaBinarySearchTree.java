package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        } else {
            if (root.val < p.val && root.val < q.val) {
                return lca(root.right, p, q);
            } else if (root.val > p.val && root.val > q.val) {
                return lca(root.left, p, q);
            } else {
                return root;
            }
        }
    }
}
