package Graph.BinaryTreeBFS;

import Library.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yizhao on 6/30/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int level = 0; // tree level from 0
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> curLevel = new Stack<>();
        curLevel.push(root);
        while (!curLevel.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Stack<TreeNode> nextLevel = new Stack<>();
            while (!curLevel.isEmpty()) {
                TreeNode u = curLevel.pop();
                tmp.add(u.val);
                if ((level % 2) != 1) { // even level
                    if (u.left != null) nextLevel.push(u.left);
                    if (u.right != null) nextLevel.push(u.right);
                } else { // odd level
                    if (u.right != null) nextLevel.push(u.right);
                    if (u.left != null) nextLevel.push(u.left);
                }
            }
            level++;
            res.add(tmp);
            curLevel = nextLevel; // swap
        }
        return res;
    }
}
