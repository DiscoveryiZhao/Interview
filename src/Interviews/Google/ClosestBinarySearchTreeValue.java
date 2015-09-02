package Interviews.Google;


/*

int closestValue(TreeNode* root, double target) {
        if (root == NULL) return res;
        double cur = (double) (root -> val);
        if (root -> val == target) {
        return root -> val;
        }

        if (res == INT_MAX || abs (res - target) > abs (cur - target)) {
        res = cur;
        }

        if (cur > target) {
        return    closestValue (root -> left, target);
        } else {
        return    closestValue (root -> right, target);
        }
*/


import Library.Leetcode.TreeNode;

public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {

    }

    static int res = Integer.MAX_VALUE;

    public static int closetValue(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        int cur = root.val;

        if (root.val == target) {
            return root.val;
        }

        if (res == Integer.MAX_VALUE || Math.abs(cur - target) < Math.abs(res - target)) {
            res = cur;
        }

        if (cur > target) {
            return closetValue(root.left, target);
        } else {
            return closetValue(root.right, target);
        }
    }

}
