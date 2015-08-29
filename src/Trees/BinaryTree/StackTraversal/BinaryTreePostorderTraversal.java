package Trees.BinaryTree.StackTraversal;

import Library.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode lastVisited = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.peek();
                if (tmp.right == null || tmp.right == lastVisited) {
                    stack.pop();
                    res.add(tmp.val);
                    lastVisited = tmp;
                } else {
                    root = tmp.right;
                }
            }
        }
        return res;
    }
}
