package Trees.BinaryTree.ButtomUp;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class InvertBinaryTree {
    public static TreeNode mirror(TreeNode root){
        if(root == null){
            return null;
        }else{
            TreeNode left = mirror(root.left); // 求左子树镜像
            TreeNode right = mirror(root.right); // 求右子树镜像
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
