package Trees.BinarySearchTree.ConstructBST;

import Library.Leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 6/29/15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        // inorderMap node value to its index in inorder results
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return conquer(preorder, inorderMap, 0, n - 1, 0);
    }

    private static TreeNode conquer(int[] pre, Map<Integer, Integer> in, int low, int high, int cur) {
        if (low > high) {
            return null;
        }
        int mid = in.get(pre[cur]);
        TreeNode root = new TreeNode(pre[cur]);
        if (mid > low) {
            root.left = conquer(pre, in, low, mid - 1, cur + 1);
        }
        if (mid < high) {
            root.right = conquer(pre, in, mid + 1, high, cur + (mid - low + 1));
        }
        return root;
    }
}
