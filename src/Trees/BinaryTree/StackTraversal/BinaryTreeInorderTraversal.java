package Trees.BinaryTree.StackTraversal;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class BinaryTreeInorderTraversal {
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<Integer>();
        }else{
            ArrayList<Integer> res = new ArrayList<>();
            Stack<TreeNode> parentStack = new Stack<TreeNode>();
            while(!parentStack.isEmpty() || root!=null){
                if(root!=null){
                    parentStack.push(root);
                    root=root.left;
                }else{
                    root = parentStack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
            return res;
        }
    }
}
