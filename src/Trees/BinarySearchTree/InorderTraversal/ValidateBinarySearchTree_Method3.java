package Trees.BinarySearchTree.InorderTraversal;

import LibraryOfLeetcode.TreeNode;

import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class ValidateBinarySearchTree_Method3 {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        Stack<TreeNode> parentStack = new Stack<>();
        while (!parentStack.isEmpty() || root != null) {
            if (root != null) {
                parentStack.push(root);
                root = root.left;
            } else {
                root = parentStack.pop();
                if (pre != null && pre.val >= root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
