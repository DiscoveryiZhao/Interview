package Recursion.DFS.PermutationsAndCombinations.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);// 去重
        dfs(num, res, new ArrayList<Integer>(), new boolean[num.length]);
        return res;
    }

    public static void dfs(int[] num, List<List<Integer>> res, List<Integer> tmp, boolean[] visit) {
        if (tmp.size() == num.length) {
            res.add(new ArrayList<>(tmp)); // 什么时候输出结果
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visit[i] == true || (i != 0 && num[i] == num[i - 1] && visit[i - 1] == false)) {
                continue;  // 什么情况跳过
            }
            visit[i] = true;
            tmp.add(num[i]);
            dfs(num, res, tmp, visit);
            tmp.remove(tmp.size() - 1);
            visit[i] = false;
        }
    }
}
