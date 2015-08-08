package Trees.AVL;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class AVLTreeRebalanceandRotation {
    public static void main(String[] args) {
        // case 1
        TreeNode L = new TreeNode(10);
        L.left = new TreeNode(5);
        L.left.left = new TreeNode(3);
        L = rebalance(L);
        System.out.println(L.val); // 5
        System.out.println(L.left.val); // 3
        System.out.println(L.right.val); // 10

        // case 2
        TreeNode LR = new TreeNode(10);
        LR.left = new TreeNode(3);
        LR.left.right = new TreeNode(5);
        LR = rebalance(LR);
        System.out.println(LR.val); // 5
        System.out.println(LR.left.val); // 3
        System.out.println(LR.right.val); // 10

        // case3
        TreeNode R = new TreeNode(3);
        R.right = new TreeNode(5);
        R.right.right = new TreeNode(10);
        R = rebalance(R);
        System.out.println(R.val); // 5
        System.out.println(R.left.val); // 3
        System.out.println(R.right.val); // 10

        // case4
        TreeNode RL = new TreeNode(3);
        RL.right = new TreeNode(10);
        RL.right.left = new TreeNode(5);
        RL = rebalance(RL);
        System.out.println(RL.val); // 5
        System.out.println(RL.left.val); // 3
        System.out.println(RL.right.val); // 10
    }

    // Rebalancing a given part of the tree.
// Returns rebalanced of given part of the tree.
    private static TreeNode rebalance(TreeNode root) {
        int hd = hightDiffer(root);
        if (hd < -1) {
            if (hightDiffer(root.left) <= 0) {
                // Case 1 fix with R rotation
                root = rightRotate(root);
            } else {
                // Case 2 fix with LR rotations
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if (hd > 1) {
            if (hightDiffer(root.right) >= 0) {
                // Case 3 fix with L rotation
                root = leftRotate(root);
            } else {
                // Case 4 fix with RL rotations
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        return root;
    }

    // Performing the right rotation of given part of the tree.
// Returns right rotated of given part of the tree..
    private static TreeNode rightRotate(TreeNode root) {
        TreeNode newRoot = root.left;
        TreeNode tmp = newRoot.right;
        newRoot.right = root;
        root.left = tmp;
        return newRoot;
    }

    // Performing the left rotation of the given part of the tree.
// Returns left rotated of given part of the tree.
    private static TreeNode leftRotate(TreeNode root) {
        TreeNode newRoot = root.right;
        TreeNode tmp = newRoot.left;
        newRoot.left = root;
        root.right = tmp;
        return newRoot;
    }

    private static int hightDiffer(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return maxDepth(root.right) - maxDepth(root.left);
        }
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
