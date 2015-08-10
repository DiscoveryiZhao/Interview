package Recursion.PermutationsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(3, 0)); // [[]]
        System.out.println(combine(3, 1)); // [[1], [2], [3]]
        System.out.println(combine(3, 2)); // [[1, 2], [1, 3], [2, 3]]
        System.out.println(combine(3, 3)); // [[1, 2, 3]]
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        vector(n, k, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void vector(int n, int k, List<List<Integer>> res, List<Integer> tmp, int depth) {
        if (tmp.size() == k) {
            res.add(new ArrayList<Integer>(tmp)); // 什么时候输出结果
            return;
        }
        for (int width = depth; width < n; width++) {
            tmp.add(width + 1);
            vector(n, k, res, tmp, width + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
