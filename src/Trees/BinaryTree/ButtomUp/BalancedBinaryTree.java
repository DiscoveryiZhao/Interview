package Trees.BinaryTree.ButtomUp;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = dfs(root.left);
            int right = dfs(root.right);

            if (left == -1 || right == -1) {
                return -1;
            }
            if (Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(1 + left, 1 + right);
        }
    }
}
