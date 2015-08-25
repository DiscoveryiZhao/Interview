package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        System.out.println(subsets(S));
    }

    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(S); // 去重
        dfs(S, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void dfs(int[] S, List<List<Integer>> res, List<Integer> tmp, int depth) {
        res.add(new ArrayList<>(tmp)); // 什么时候输出结果
        for (int width = depth; width < S.length; width++) {
            tmp.add(S[width]);
            dfs(S, res, tmp, width + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
