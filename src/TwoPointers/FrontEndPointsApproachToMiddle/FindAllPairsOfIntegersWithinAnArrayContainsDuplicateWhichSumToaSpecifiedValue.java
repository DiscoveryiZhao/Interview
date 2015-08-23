package TwoPointers.FrontEndPointsApproachToMiddle;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class FindAllPairsOfIntegersWithinAnArrayContainsDuplicateWhichSumToaSpecifiedValue {
    public static void main(String[] args) {
        int[] test1 = {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
        // -2,14
        // -1,13
        // 3,9
        // 5,7
        printPairSums(test1, 12);
    }

    public static void printPairSums(int[] num, int target) {
        int n = num.length;
        if (n < 2) {
            return;
        }
        Arrays.sort(num);
        int L = 0;
        int R = n - 1;
        while (L < R) {
            int sum = num[L] + num[R];
            if (sum == target) {
                System.out.println(num[L] + "," + num[R]);
                L++;
                R--;
            } else if (sum < target) {
                L++;
            } else {
                R--;
            }
        }
    }
}