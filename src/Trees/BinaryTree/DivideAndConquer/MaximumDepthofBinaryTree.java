package Trees.BinaryTree.DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 8/7/15.
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.max(l, r) + 1;
    }
}
