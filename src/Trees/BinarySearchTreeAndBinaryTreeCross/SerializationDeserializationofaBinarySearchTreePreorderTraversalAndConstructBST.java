package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfLeetcode.TreeNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by yizhao on 6/29/15.
 */
public class SerializationDeserializationofaBinarySearchTreePreorderTraversalAndConstructBST {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        // "3 2 1 5 4 6 "
        serialize(root, "C:\\Users\\Yi\\Desktop\\test.txt");

        TreeNode d = deserialize("C:\\Users\\Yi\\Desktop\\test.txt");
        System.out.println(d.val); // 3
        System.out.println(d.left.val); // 2
        System.out.println(d.left.left.val); // 1
        System.out.println(d.right.val); // 5
        System.out.println(d.right.left.val); // 4
        System.out.println(d.right.right.val); // 6
    }

    public static void serialize(TreeNode root, String fileAddr) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileAddr)));
        dfs(root, bw);
        bw.flush();
        bw.close();
    }

    public static void dfs(TreeNode root, BufferedWriter bw) throws Exception {
        if (root == null) {
            return;
        }
        bw.write(root.val + " ");
        dfs(root.left, bw);
        dfs(root.right, bw);
    }

    public static TreeNode deserialize(String fileAddr) throws Exception {
        Scanner sc = new Scanner(new File(fileAddr));
        if (sc.hasNext()) {
            int[] nextVal = {Integer.valueOf(sc.next())};
            return constructBST(nextVal, Integer.MIN_VALUE, Integer.MAX_VALUE, sc);
        }
        sc.close();
        return null;
    }

    private static TreeNode constructBST(int[] nextVal, int low, int high, Scanner sc) {
        // topdown boundary from validate of BST problem
        if (nextVal[0] < low || nextVal[0] > high) {
            return null;
        }
        TreeNode root = new TreeNode(nextVal[0]);
        if (sc.hasNext()) {
            nextVal[0] = Integer.valueOf(sc.next());
            root.left = constructBST(nextVal, low, root.val - 1, sc);
            root.right = constructBST(nextVal, root.val + 1, high, sc);
        }
        return root;
    }
}
