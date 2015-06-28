package PermutationsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
        System.out.println(permute(S));
    }
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        vector(num, res, new ArrayList<Integer>());
        return res;
    }

    public static void vector(int[] num, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == num.length) {
            res.add(new ArrayList<>(tmp)); // 什么时候输出结果
            return;
        }
        for (int width = 0; width < num.length; width++) {
            if (tmp.contains(num[width])) continue; // 什么情况跳过
            tmp.add(num[width]);
            vector(num, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
