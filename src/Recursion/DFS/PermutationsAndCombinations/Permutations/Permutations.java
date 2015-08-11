package Recursion.DFS.PermutationsAndCombinations.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        System.out.println(permute(S));
    }

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        vector(num, res, new ArrayList<Integer>(), new boolean[num.length]);
        return res;
    }

    public static void vector(int[] num, List<List<Integer>> res, List<Integer> tmp, boolean[] visit) {
        if (tmp.size() == num.length) {
            res.add(new ArrayList<>(tmp)); // 什么时候输出结果
            return;
        }
        for (int width = 0; width < num.length; width++) {
            if (visit[width] == true) {
                continue; // 什么情况跳过
            }
            visit[width] = true;
            tmp.add(num[width]);
            vector(num, res, tmp, visit);
            tmp.remove(tmp.size() - 1);
            visit[width] = false;
        }
    }
}
