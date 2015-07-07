package TwoPointers.ShuangJiBiZhongFa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 7/1/15.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        int n = num.length ;
        if (n < 3) {
            return new ArrayList<>();
        } else {
            List<List<Integer>> res = new ArrayList<>();
            Arrays. sort(num);
            for (int i = 0; i < n - 2; i++) {
                int L = i + 1;
                int R = n - 1;
                while (L < R) {
                    int sum = num[i] + num[L] + num[R];
                    if(sum == 0){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[L]);
                        tmp.add(num[R]);
                        res.add(tmp);
                        // skip duplicates
                        while (L < R && num[L] == num[L + 1]) L++;
                        while (L < R && num[R - 1] == num[R]) R--;
                        L++;
                        R--;
                    } else if (sum < 0) {
                        L++;
                    } else { // sum > 0
                        R--;
                    }
                }

                // skip duplicates
                while (i < n-3 && num[i] == num[i + 1]) i++;
            }
            return res;
        }
    }
}
