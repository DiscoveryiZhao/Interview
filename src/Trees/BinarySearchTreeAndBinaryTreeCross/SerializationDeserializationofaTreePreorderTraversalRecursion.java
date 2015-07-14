package Trees.BinarySearchTreeAndBinaryTreeCross;

import LibraryOfLeetcode.TreeNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by yizhao on 6/29/15.
 */
public class SerializationDeserializationofaTreePreorderTraversalRecursion {
    public static void main(String[] args) throws Exception {
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

    public static void serialize(TreeNode root, String fileAddr) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileAddr)));
        dfs(root, bw);
        bw.flush();
        bw.close();

    }

    public static void dfs(TreeNode root, BufferedWriter bw) throws Exception {
        if (root == null) {
            bw.write("# ");
        } else {
            bw.write(root.val + " ");
            dfs(root.left, bw);
            dfs(root.right, bw);
        }
    }

    public static TreeNode deserialize(String fileAddr) throws Exception {
        TreeNode root = null;
        Scanner sc = new Scanner(new File(fileAddr));
        if (sc.hasNext()) {
            String[] nextVal = {sc.next()};
            root = constructBT(nextVal, sc);
        }
        sc.close();
        return root;
    }

    private static TreeNode constructBT(String[] nextVal, Scanner sc) {
        if (nextVal[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nextVal[0]));
        if (sc.hasNext()) {
            nextVal[0] = sc.next();
            root.left = constructBT(nextVal, sc);
        }
        if (sc.hasNext()) {
            nextVal[0] = sc.next();
            root.right = constructBT(nextVal, sc);
        }
        return root;
    }
}
