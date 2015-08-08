package Trees.BinaryTree.Recursion_DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        // Conquer
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        // Divide
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
