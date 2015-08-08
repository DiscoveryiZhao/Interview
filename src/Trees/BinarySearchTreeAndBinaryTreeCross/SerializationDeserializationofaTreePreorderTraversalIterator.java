package Trees.BinarySearchTreeAndBinaryTreeCross;

import Library.Leetcode.TreeNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yizhao on 6/29/15.
 */
public class SerializationDeserializationofaTreePreorderTraversalIterator {
    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        // "1 2 4 # # 5 # # 3 # # "
        serialize(root, "C:\\Users\\Yi\\Desktop\\test.txt");
        TreeNode d = deserialize("C:\\Users\\Yi\\Desktop\\test.txt");
        System.out.println(d.val); // 1
        System.out.println(d.left.val); // 2
        System.out.println(d.left.left.val); // 4
        System.out.println(d.left.right.val); // 5
        System.out.println(d.right.val); // 3
    }


    public static void serialize(TreeNode root, String fileAddr) throws IOException {
        if (root == null) {
            return;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileAddr)));
        Stack<TreeNode> parentStack = new Stack<>();
        while (parentStack.size() != 0 || root != null) {
            if (root != null) {
                bw.write(root.val + " ");
                parentStack.push(root);
                root = root.left;
            } else {
                bw.write("# ");
                root = parentStack.pop();
                root = root.right;
            }
        }
        bw.write("# "); // don't forget write the last #
        bw.flush();
        bw.close();
    }

    public static TreeNode deserialize(String fileAddr) throws IOException {
        TreeNode root = null;
        Scanner sc = new Scanner(new File(fileAddr));
        if (sc.hasNext()) {
            String tmp = sc.next();
            if (tmp.equals("#")) {
                sc.close();
                return null;
            } else {
                root = new TreeNode(Integer.valueOf(tmp));
            }
        } else {
            sc.close();
            return null;
        }

        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode cur = root; // need an extra cur pointer since we need to return root
        while (parentStack.size() != 0 || cur != null) {
            if (cur != null) {
                parentStack.push(cur);
                if (sc.hasNext()) {
                    String tmp = sc.next();
                    if (!tmp.equals("#")) {
                        cur.left = new TreeNode(Integer.valueOf(tmp));
                    }
                }
                cur = cur.left;
            } else {
                cur = parentStack.pop();
                if (sc.hasNext()) {
                    String tmp = sc.next();
                    if (!tmp.equals("#")) {
                        cur.right = new TreeNode(Integer.valueOf(tmp));
                    }
                }
                cur = cur.right;
            }
        }
        sc.close();
        return root;
    }

}
