package TwoPointers.ShuangJiBiZhongFa;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] test1 = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(test1, 1)); // 2
    }

    public static int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if (n < 3) { // if less than three items then return 0
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        for (int i = 0; i < n - 2; i++) {
            int L = i + 1;
            int R = n - 1;
            while (L < R) {
                int sum = num[i] + num[L] + num[R];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return res;
                } else if (sum < target) {
                    L++;
                } else {
                    R--;
                }
            }
            while (i < n - 3 && num[i] == num[i + 1]) i++;
        }
        return res;
    }
}
