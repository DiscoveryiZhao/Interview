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
            return root; // 如果当前节点左右节点都各找到一个，那么返回当前节点
        }
        if (l != null) {
            return l; //只在左节点或者右节点找到一个，说明还有一个节点是在当前节点的下面
        }
        if (r != null) {
            return r; //只在左节点或者右节点找到一个，说明还有一个节点是在当前节点的下面
        }
        return null;
    }
}
