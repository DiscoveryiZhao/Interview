package Trees.BinarySearchTree.InorderTraversal;

import LibraryOfLeetcode.TreeNode;

import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class RecoverBinarySearchTree {
    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> parentStack = new Stack<>();
        while (!parentStack.isEmpty() || root != null) {
            if (root != null) {
                parentStack.push(root);
                root = root.left;
            } else {
                root = parentStack.pop();
                if (pre != null && pre.val >= root.val) {
                    if (first == null) {
                        // the first wrong item should be the bigger one
                        first = pre;
                        // there is first chance that the two were swapped
                        second = root;
                    } else {
                        // the second wrong item should be the smaller one
                        second = root;
                        break;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        swap(first, second);
    }

    private static void swap(TreeNode first, TreeNode second) {
        if (first == null || second == null) {
            return;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
