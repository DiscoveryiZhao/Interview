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
        vector(num, res, new ArrayList<Integer>(), new boolean[num.length]);
        return res;
    }

    public static void vector(int[] num, List<List<Integer>> res, List<Integer> tmp, boolean[] visit) {
        if (tmp.size() == num.length) {
            res.add(new ArrayList<>(tmp)); // 什么时候输出结果
            return;
        }
        for (int width = 0; width < num.length; width++) {
            if (visit[width] == true || (width != 0 && num[width] == num[width - 1] && visit[width - 1] == false)) {
                continue;  // 什么情况跳过
            }
            visit[width] = true;
            tmp.add(num[width]);
            vector(num, res, tmp, visit);
            tmp.remove(tmp.size() - 1);
            visit[width] = false;
        }
    }
}
