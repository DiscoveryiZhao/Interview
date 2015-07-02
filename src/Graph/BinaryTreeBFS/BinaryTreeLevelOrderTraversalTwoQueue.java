package Graph.BinaryTreeBFS;

import LibraryOfLeetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class BinaryTreeLevelOrderTraversalTwoQueue {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();//新建一个queue，用来记录哪些nodes是目前的波前
        queue.add(root); // 向root注水作为波前
        queue.add(null); // 在波前队列queue加null作为Flag代表这层level已访问结束
        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            if (u != null) {
                level.add(u.val);

                            /*
                            * 波前u向其所有有连同的node扩散
                            * u是v的predecessor前驱 or parent
                            * v是u的 descendent后记
                            * */
                if (u.left != null) {
                    queue.add(u.left);
                }
                if (u.right != null) {
                    queue.add(u.right);
                }
            } else {
                res.add(level);
                level = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return res;
    }
}
