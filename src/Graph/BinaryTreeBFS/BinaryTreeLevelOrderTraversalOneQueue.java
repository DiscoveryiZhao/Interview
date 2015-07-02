package Graph.BinaryTreeBFS;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class BinaryTreeLevelOrderTraversalOneQueue {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            while (!curLevel.isEmpty()) {
                TreeNode u = curLevel.poll();
                tmp.add(u.val);
                if (u.left != null) nextLevel.add(u.left);
                if (u.right != null) nextLevel.add(u.right);
            }
            res.add(tmp);
            curLevel = nextLevel; // swap
        }
        return res;
    }


}
