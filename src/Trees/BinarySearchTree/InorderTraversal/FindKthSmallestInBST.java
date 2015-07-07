package Trees.BinarySearchTree.InorderTraversal;

import LibraryOfLeetcode.TreeNode;

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

        findKthSmallest(root, 1); // 1
        findKthSmallest(root, 2); // 2
        findKthSmallest(root, 3); // 3
        findKthSmallest(root, 4); // 4
        findKthSmallest(root, 5); // 5
        findKthSmallest(root, 6); // 6
    }

    public static int count;

    public static void findKthSmallest(TreeNode root, int k) {
        count = 1;
        dfs(root, k);
    }

    public static void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        } else {
            dfs(root.left, k);
            if (count == k) {
                System.out.println(root.val);
            }
            count++;
            dfs(root.right, k);
        }
    }
}
