package Trees.BinaryTree.TopDown;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class AmplitudeOfTree {
    public static int amp = 0;
    public static int sol(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            amp = 0;
            helper(root, root.val, root.val);
            return amp ;
        }
    }

    public static void helper(TreeNode root, int pathMin, int pathMax) {
        if (root == null) {
            return;
        } else {
            pathMin = Math. min(pathMin, root.val);
            pathMax = Math. max(pathMax, root.val);
            if (root.left == null && root.right == null) {
                amp = Math.max( amp, pathMax - pathMin);
            }

            helper(root.left, pathMin, pathMax);
            helper(root.right, pathMin, pathMax);
        }
    }
}
