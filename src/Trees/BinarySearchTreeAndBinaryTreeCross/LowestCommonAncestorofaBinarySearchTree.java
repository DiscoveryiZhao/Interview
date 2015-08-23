package Trees.BinarySearchTreeAndBinaryTreeCross;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if(root == p || root == q){
            return root; //如果当前节点为p,q之中的一个，那么返回当前找到的节点中的一个
        }

        if (root.val < p.val && root.val < q.val) {
            return lca(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lca(root.left, p, q);
        } else { // (root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)
            return root;
        }
    }
}
