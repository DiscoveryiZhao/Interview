package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfLeetcode.TreeNode;

import java.util.Stack;

/**
 * Created by yizhao on 7/14/15.
 */
public class ValidateBinarySearchTreeInorderStackTraversal {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        while (parentStack.size() != 0 || root != null) {
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
