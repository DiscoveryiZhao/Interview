package Trees.BinaryTree.Recursion_Traversal;

import Library.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/29/15.
 */
public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    public static boolean helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        tmp.add(root.val);
        if (sum == 0) {
            // 题目说了为root-to-leaf path sum相加，所以leaf的定义为无子节点，所以必须加上这个条件
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(tmp));
            }
        }

        // from root to deepest left and right leaf traversal
        if (helper(root.left, sum, res, tmp) || helper(root.right, sum, res, tmp)) {
            return true;
        }

        tmp.remove(tmp.size() - 1);
        return false;
    }
}
