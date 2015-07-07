package Math.Other;

import java.util.Arrays;

/**
 * Created by yizhao on 6/30/15.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] test1 = {9, 9, 9};
        int[] test2 = {9, 9, 7};
        System.out.println(Arrays.toString(plusOne(test1))); // [1, 0, 0, 0]
        System.out.println(Arrays.toString(plusOne(test2))); // [9, 9, 8]
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
