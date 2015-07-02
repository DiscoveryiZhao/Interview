package TwoPointers.ShuangJiBiZhongFa;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] test1 = { -1, 2, 1, -4 };
        System. out.println(threeSumClosest(test1, 1)); // 2
    }

    public static int threeSumClosest(int[] num, int target) {
        int n = num.length ;
        if (n < 3) { // if less than three items then return 0
            return Integer.MAX_VALUE ;
        } else {
            Arrays. sort(num);
            int res = num[0] + num[1] + num[2];
            for (int i = 0; i < n - 2; i++) {
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = num[i] + num[left] + num[right];
                    if (Math.abs(sum - target) < Math. abs(res - target)) {
                        res = sum;
                    }
                    if (sum == target) {
                        return res;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (i < n - 3 && num[i] == num[i + 1]) i++;
            }
            return res;
        }
    }
}
