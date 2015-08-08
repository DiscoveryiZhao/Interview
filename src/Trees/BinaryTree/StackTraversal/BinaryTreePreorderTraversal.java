package Trees.BinaryTree.StackTraversal;

import Library.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> parentStack = new Stack<>();
        while (!parentStack.isEmpty() || root != null) {
            if (root != null) {
                res.add(root.val);
                parentStack.push(root);
                root = root.left;
            } else {
                root = parentStack.pop();
                root = root.right;
            }
        }
        return res;
    }
}
