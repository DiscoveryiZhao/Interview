package Trees.AVL;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinarySearchTreeSelfBalancedInsert {
    public static void main(String[] args) {
        TreeNode root = null; // {1,2,3,4,5,6,7,8}
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 5);
        root = insert(root, 6);
        root = insert(root, 7);
        root = insert(root, 8);
        System.out.println(root.val); // 4
        System.out.println(root.left.val); // 2
        System.out.println(root.left.left.val); // 1
        System.out.println(root.left.right.val); // 3
        System.out.println(root.right.val); // 6
        System.out.println(root.right.left.val); // 5
        System.out.println(root.right.right.val); // 7
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val); // reached dead end; put new node here
        } else {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                root.right = insert(root.right, val);
            } else { // if (root.val > val)
                root.left = insert(root.left, val);
            }
        }
        return rebalance(root);
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
