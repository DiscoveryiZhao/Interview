package Trees.BinarySearchTree.InorderTraversal;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class ValidateBinarySearchTree_Method1 {

    public static Integer pre;

    public static boolean isValidBST(TreeNode root) {
        pre = null;
        return dfs(root);
    }

    public static boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        } else {
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
}
