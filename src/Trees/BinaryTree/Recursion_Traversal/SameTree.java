package Trees.BinaryTree.Recursion_Traversal;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        // same tree need two conditions.
        // first same structure
        // second same values
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        // from root to deepest left and right leaf traversal
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
