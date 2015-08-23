package Trees.BinarySearchTreeAndBinaryTreeCross;

import Library.Leetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class LowestCommonAncestorofaBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null; //如果当前节点为NULL说明走到了叶节点都没有找到两个节点中的其中一个
        }

        if(root == p || root == q){
            return root; //如果当前节点为p,q之中的一个，那么返回当前找到的节点中的一个
        }
        // Divide
        TreeNode l = lowestCommonAncestor(root.left, p, q); // Lowest Common Ancestor of left subtree
        TreeNode r = lowestCommonAncestor(root.right, p, q); // Lowest Common Ancestor of right subtree

        // Conquer
        if (l != null && r != null) {
            return root; // 以当前节点为根, 在其左和右子树都找到，那么返回当前节点。
        }
        if (l != null) {
            return l; //以当前节点为根, 在其左子树找到，那么返回其左子树，继续在其左子树递归查找。
        }
        if (r != null) {
            return r; //以当前节点为根, 在其右子树找到，那么返回其右子树，继续在其右子树递归查找。
        }

        // 以当前节点为根的子树根本就不存在p和q
        return null;
    }
}
