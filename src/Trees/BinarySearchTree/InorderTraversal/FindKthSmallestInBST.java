package Trees.BinarySearchTree.InorderTraversal;

import Library.Leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class FindKthSmallestInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        System.out.println(kthSmallest(root, 1)); // 1
        System.out.println(kthSmallest(root, 2)); // 2
        System.out.println(kthSmallest(root, 3)); // 3
        System.out.println(kthSmallest(root, 4)); // 4
        System.out.println(kthSmallest(root, 5)); // 5
        System.out.println(kthSmallest(root, 6)); // 6
    }

    /*
    * We can inorder traverse the tree and get the kth smallest element. Time is O(n).
    * */
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0) {
                    result = t.val;
                    break;
                }
                root = t.right;
            }
        }
        return result;
    }
}
