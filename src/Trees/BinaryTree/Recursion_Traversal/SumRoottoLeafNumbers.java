package Trees.BinaryTree.Recursion_Traversal;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class SumRoottoLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        return traversal(root, 0);
    }

    public static int traversal(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }

        // from root to deepest left and right leaf traversal
        return traversal(node.left, sum) + traversal(node.right, sum);
    }
}
