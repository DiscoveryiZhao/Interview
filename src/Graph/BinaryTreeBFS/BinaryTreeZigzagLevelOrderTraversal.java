package Graph.BinaryTreeBFS;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yizhao on 6/30/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        } else {
            int level = 0; // tree level from 0
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            Stack<TreeNode> curLevel = new Stack<TreeNode>();
            curLevel.push(root);
            while (!curLevel.isEmpty()) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                Stack<TreeNode> nextLevel = new Stack<TreeNode>();
                while (!curLevel.isEmpty()) {
                    TreeNode u = curLevel.pop();
                    tmp.add(u. val);
                    if ((level & 1) != 1) { // even level
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
}
