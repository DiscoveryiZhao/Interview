package Trees.BinaryTree.StackTraversal;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> parentStack = new Stack<>();
        while (!parentStack.isEmpty() || root != null) {
            if (root != null) {
                parentStack.push(root);
                root = root.left;
            } else {
                root = parentStack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
