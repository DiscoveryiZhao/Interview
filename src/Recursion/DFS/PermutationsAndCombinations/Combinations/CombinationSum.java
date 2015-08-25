package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] num = {2, 3, 6, 7};
        System.out.println(combinationSum(num, 7)); // [[2, 2, 3], [7]]
    }

    public static List<List<Integer>> combinationSum(int[] num, int sum) {
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
            tmp.add(num[i]);
            // 这里pass入i而不是i+1进recursion，不同于Combinations那题，是因为题目支持一个数可以用很多次
            dfs(num, sum - num[i], res, tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
