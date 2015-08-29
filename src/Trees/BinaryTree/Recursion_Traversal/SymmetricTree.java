package Trees.BinaryTree.Recursion_Traversal;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traversal(root.left, root.right);
    }

    public static boolean traversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        // from root to deepest left and right leaf traversal
        return traversal(p.left, q.right) && traversal(p.right, q.left);
    }
}
