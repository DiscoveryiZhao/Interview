package Trees.BinaryTree.DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(2);
        System.out.println(maxPathSum(root));
    }

    public static int optSol; // 从树中任意到任意点的最大路径，这条路径至少包含一个点

    public static int maxPathSum(TreeNode root) {
        optSol = Integer.MIN_VALUE;
        helper(root); // 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        return optSol;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Divide
        int l = helper(root.left); // the maxPathSum of left subtree, 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        int r = helper(root.right); // the maxPathSum of right subtree, 从root往下走到任意点的最大路径，这条路径可以不包含任何点

        // Conquer
        int sum = root.val;
        if (l > 0) sum += l; // 如果L大于0，那么对后续是有利的，我们加上L。
        if (r > 0) sum += r; // 如果R大于0， 那么对后续是有力的， 我们加上R。
        optSol = Math.max(optSol, sum); // 从树中任意到任意点的最大路径，这条路径至少包含一个点
        if (l < 0 && r < 0) return sum; // 如果L， R都小于等于0， 那么左右两边对后续都是无利甚至有害的，我们从这个节点，另起一个路径。
        return Math.max(l, r) + root.val;
    }
}
