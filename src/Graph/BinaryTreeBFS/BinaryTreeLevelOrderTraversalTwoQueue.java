package Graph.BinaryTreeBFS;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class BinaryTreeLevelOrderTraversalTwoQueue {
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        } else {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
            curLevel.add(root);
            while (!curLevel.isEmpty()) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
                while (!curLevel.isEmpty()) {
                    TreeNode u = curLevel.poll();
                    tmp.add(u. val);
                    if (u.left != null) nextLevel.add(u.left);
                    if (u.right != null) nextLevel.add(u.right);
                }
                res.add(tmp);
                curLevel = nextLevel; // swap
            }
            return res;
        }
    }


}
