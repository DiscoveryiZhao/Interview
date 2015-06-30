package Trees.BinaryTree.MorrisTraversal;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;

/**
 * Created by yizhao on 6/29/15.
 */
public class InorderBinaryTreeTraversalwithConstantSpace {
    public static ArrayList<Integer> morrisInorderTraversal(TreeNode root){
        ArrayList<Integer> values = new ArrayList<Integer>();
        inorderMorris(root, values);
        return values;
    }

    public static void inorderMorris(TreeNode root, ArrayList<Integer> values) {
        TreeNode cur = root;
        while (cur != null ) {
            if (cur.left != null) {
                      /* Find the inorder parent of cur */
                TreeNode curLeft = cur. left;
                while (curLeft.right != null && curLeft.right != cur) {
                    curLeft = curLeft. right;
                }
                      /* Make cur as right child of its inorder parent */
                if (curLeft.right == null) { // set right to successor
                    curLeft. right = cur;
                    cur = cur. left;
                } else { // visit and revert the change
                            /* Revert the changes made in if part to restore the original
                                  tree i.e., fix the right child of parent */
                    values.add(cur. val);
                    cur = cur. right;
                }
            } else { // visit and move to successor
                values.add(cur. val);
                cur = cur. right;
            }
        }
    }
}
