package Trees.BinaryTree.StackTraversal;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        } else {
            TreeNode lastVisited = null;
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> parentStack = new Stack<>();
            while (!parentStack.isEmpty() || root != null) {
                if (root != null) {
                    parentStack.push(root);
                    root = root.left;
                } else {
                    TreeNode tmp = parentStack.peek();
                    if (tmp.right == null || tmp.right == lastVisited) {
                        parentStack.pop();
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
}
