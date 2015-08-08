package Trees.BinarySearchTree.InorderTraversal;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 7/14/15.
 */
public class ValidateBinarySearchTreeRecursionInorder {

    public static Integer pre;

    public static boolean isValidBST(TreeNode root) {
        pre = null;
        return dfs(root);
    }

    public static boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left)) {
            return false;
        }

        if (pre != null && pre >= root.val) {
            return false;
        }
        pre = root.val;

        if (!dfs(root.right)) {
            return false;
        }
        return true;
    }
}
