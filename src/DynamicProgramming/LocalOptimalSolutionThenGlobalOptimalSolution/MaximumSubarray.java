package DynamicProgramming.LocalOptimalSolutionThenGlobalOptimalSolution;

/**
 * Created by yizhao on 5/18/15.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] test1 = {}; // 0
        int[] test2 = {0}; // 0
        int[] test3 = {1}; // 1
        int[] test4 = {2}; // 2
        int[] test5 = {0, 1}; // 1
        int[] test6 = {0, -1}; // 0
        int[] test7 = {-1, 1}; // 1
        int[] test8 = {1, -3, 5, -2, 9, -8, -6, 4}; // 12
        int[] test9 = {-2, -1, -6, -3}; // -1
        System.out.println(maxSubArray(test1)); // 0
        System.out.println(maxSubArray(test2)); // 0
        System.out.println(maxSubArray(test3)); // 1
        System.out.println(maxSubArray(test4)); // 2
        System.out.println(maxSubArray(test5)); // 1
        System.out.println(maxSubArray(test6)); // 0
        System.out.println(maxSubArray(test7)); // 1
        System.out.println(maxSubArray(test8)); // 12
        System.out.println(maxSubArray(test9)); // -1
    }

    public static int maxSubArray(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int local = A[0];
        int global = A[0];
        for (int i = 1; i < n; i++) {
            local = Math.max(local + A[i], A[i]); // index 0 + index 1 和 index 1 谁大取谁
            global = Math.max(global, local);
        }
        return global;
    }
}
