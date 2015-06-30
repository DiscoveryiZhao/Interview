package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfCtCI.TreeNode;

/**
 * Created by yizhao on 6/29/15.
 */
public class NextNode {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode root = TreeNode. createMinimalBST(array);
        // 1->2
        // 2->3
        // 3->4
        // 4->5
        // 5->6
        // 6->7
        // 7->8
        // 8->9
        // 9->null
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = nextNode(node);
            if (next != null) {
                System. out.println(node.data + "->" + next.data );
            } else {
                System. out.println(node.data + "->" + null);
            }
        }
    }

    public static TreeNode nextNode(TreeNode node) {
        if (node == null) {
            return null ;
        } else {
            // Found right children -> return left most node of right subtree
            if (node.right != null) {
                return leftMostChild(node. right);
            } else {
                TreeNode nodeParent = node. parent;
                // Go up until we’re on left instead of right
                while (nodeParent != null && nodeParent.right == node) {
                    node = nodeParent;
                    nodeParent = nodeParent. parent;
                }
                return nodeParent;
            }
        }
    }

    public static TreeNode leftMostChild(TreeNode node) {
        while (node.left != null) {
            node = node. left;
        }
        return node;
    }
}
