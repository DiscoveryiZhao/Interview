package PermutationsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        helper(num, res, new ArrayList<Integer>());
        return res;
    }

    public static void helper(int[] num, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == num.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (tmp.contains(num[i])) {
                continue;
            }
            tmp.add(num[i]);
            helper(num, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
