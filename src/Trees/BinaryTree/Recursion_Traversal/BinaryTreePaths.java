package Trees.BinaryTree.Recursion_Traversal;

import Library.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YZ on 9/8/15.
 */
public class BinaryTreePaths {
    public static void main(String[] args){

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        traversal(root, result, root.val + "");
        return result;
    }

    private static void traversal(TreeNode root, List<String> result, String cur) {
        if (root.left == null && root.right == null) {
            result.add(cur);
            return;
        }
        if (root.left != null) {
            traversal(root.left, result, cur + "->" + root.left.val);
        }
        if (root.right != null) {
            traversal(root.right, result, cur + "->" + root.right.val);
        }
    }
}
