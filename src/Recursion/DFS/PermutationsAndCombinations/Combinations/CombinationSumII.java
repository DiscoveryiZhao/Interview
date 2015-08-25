package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] num = {2, 3, 6, 7};
        System.out.println(combinationSum2(num, 7)); // [[7]]

    }

    public static List<List<Integer>> combinationSum2(int[] num, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);// 去重
        dfs(num, sum, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void dfs(int[] num, int sum, List<List<Integer>> res, List<Integer> tmp, int depth) {
        if (sum <= 0) {
            if (sum == 0) {
                res.add(new ArrayList<>(tmp)); // 什么时候输出结果
            }
            return;
        }
        for (int i = depth; i < num.length; i++) {
            if (i != depth && num[i] == num[i - 1]) continue; // 什么情况跳过
            tmp.add(num[i]);
            // 这里pass入i+1而不是i进recursion，不同于Combination Sum那题，是因为一个数只能用一次
            dfs(num, sum - num[i], res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
