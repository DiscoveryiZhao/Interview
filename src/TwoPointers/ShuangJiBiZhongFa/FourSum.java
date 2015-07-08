package TwoPointers.ShuangJiBiZhongFa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 7/1/15.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                // use two pointers to find the rest of two elements
                int L = j + 1;
                int R = n - 1;
                while (L < R) {
                    int sum = num[i] + num[j] + num[L] + num[R];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[L]);
                        tmp.add(num[R]);
                        res.add(tmp);
                        // skip duplicates
                        while (L < R && num[L] == num[L + 1]) L++;
                        while (L < R && num[R - 1] == num[R]) R--;
                        L++;
                        R--;
                    } else if (sum < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
                // skip duplicates
                while (j < n - 3 && num[j] == num[j + 1]) j++;
            }
            // skip duplicates
            while (i < n - 4 && num[i] == num[i + 1]) i++;
        }
        return res;
    }
}
