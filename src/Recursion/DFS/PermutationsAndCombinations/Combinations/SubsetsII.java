package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] S = {1, 2, 2};
        // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
        System.out.println(subsetsWithDup(S));
    }


    public static List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(S);// 去重
        vector(S, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void vector(int[] S, List<List<Integer>> res, List<Integer> tmp, int depth) {
        res.add(new ArrayList<>(tmp)); // 什么时候输出结果
        for (int width = depth; width < S.length; width++) {
            if (width != depth && S[width] == S[width - 1]) continue; // 什么情况跳过
            tmp.add(S[width]);
            vector(S, res, tmp, width + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
