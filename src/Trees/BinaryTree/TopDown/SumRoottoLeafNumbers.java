package Trees.BinaryTree.TopDown;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class SumRoottoLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int sum) {
        if (node == null){
            return 0;
        } else{
            sum=  sum * 10 + node. val;
            if (node.left == null && node.right == null){
                return sum;
            }
            return dfs(node. left, sum) + dfs(node.right, sum);
        }
    }
}
