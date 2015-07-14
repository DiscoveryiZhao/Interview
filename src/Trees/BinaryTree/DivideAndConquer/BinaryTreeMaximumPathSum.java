package Trees.BinaryTree.DivideAndConquer;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreeMaximumPathSum {

    public static int optSol; // optimalSolution

    public static int maxPathSum(TreeNode root) {
        optSol = Integer.MIN_VALUE;
        helper(root);
        return optSol;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Divide
        int sumL = helper(root.left);
        int sumR = helper(root.right);

        // Conquer
        int sum = root.val;
        if (sumL > 0) sum += sumL; // 如果L大于0，那么对后续是有利的，我们加上L。
        if (sumR > 0) sum += sumR; // 如果R大于0， 那么对后续是有力的， 我们加上R。
        optSol = Math.max(optSol, sum);
        if (sumL < 0 && sumR < 0) return sum; // 如果L， R都小于等于0， 那么左右两边对后续都是无利甚至有害的，我们从这个节点，另起一个路径。
        return Math.max(root.val + sumL, root.val + sumR);
    }
}
