package Trees.BinarySearchTree.ConstructBST;

import LibraryOfLeetcode.TreeNode;

import java.util.HashMap;

/**
 * Created by yizhao on 6/29/15.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        // inorderMap inorder values to their indices
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        // build the tree
        // read postorder values backwards
        return conquer(inorderMap, postorder, 0, n - 1, n - 1);
    }

    private static TreeNode conquer(HashMap<Integer, Integer> in, int[] post, int low, int high, int cur) {
        if (low > high) {
            return null;
        }
        int mid = in.get(post[cur]);
        TreeNode root = new TreeNode(post[cur]);
        // read postorder values backwards
        root.left = conquer(in, post, low, mid - 1, cur - (high - mid + 1));
        root.right = conquer(in, post, mid + 1, high, cur - 1);
        return root;
    }
}
