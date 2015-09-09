package Trees.BinaryTree.Recursion_Traversal;

import Library.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:
          1
        /   \
        2     3
                \
                5
All root-to-leaf paths are:
["1->2->5", "1->3"]
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
