package Trees.BinaryTree.DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Divide
        TreeNode L = invertTree(root.left); // 求左子树镜像
        TreeNode R = invertTree(root.right); // 求右子树镜像

        // Conquer
        root.left = R;
        root.right = L;
        return root;
    }
}
