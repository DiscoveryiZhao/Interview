package Trees.BinaryTree.MorrisTraversal;

import LibraryOfLeetcode.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class FlattenBinaryTreetoLinkedList {
    public static void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null ) {
            if (cur.left != null) {
                TreeNode curLeft = cur. left;
                while (curLeft.right != null && curLeft.right != cur) {
                    curLeft = curLeft. right;
                }
                if(curLeft.right ==null){
                    curLeft. right = cur. right;
                }
                cur. right = cur. left;
                cur. left = null;
            } else{
                cur = cur. right;
            }
        }
    }
}
