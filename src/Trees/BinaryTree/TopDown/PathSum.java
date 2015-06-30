package Trees.BinaryTree.TopDown;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false ;
        } else {
            sum -= root. val;
            if (sum == 0) {
                // 题目说了为root-to-leaf path sum相加，所以leaf的定义为无子节点，所以必须加上这个条件
                if (root.left == null && root.right == null) { // reach a leaf
                    return true ;
                }
            }
            return hasPathSum(root. left, sum) || hasPathSum(root.right, sum);
        }
    }
}
