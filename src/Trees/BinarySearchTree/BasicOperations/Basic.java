package Trees.BinarySearchTree.BasicOperations;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class Basic {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root = insert(root, 20);
        root = insert(root, 23);
        root = insert(root, 10);
        //root = insert(root, 11);
        //System.out.println(levelOrder(root));
    }

    public static boolean contains(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return contains(root.right, target);
        } else {
            return contains(root.left, target);
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            root.right = insert(root.right, val);
        } else { // if (root.val > val)
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else {
                // both children; replace w/ min from R
                root.val = getMin(root.right);
                root.right = delete(root.right, root.val);
            }
        } else if (root.val < val) {
            root.right = delete(root.right, val);
        } else { // if (root.val > val)
            root.left = delete(root.left, val);
        }
        return root;
    }

    public static int getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static int getMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}
