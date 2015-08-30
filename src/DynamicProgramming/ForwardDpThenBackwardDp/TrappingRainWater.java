package DynamicProgramming.ForwardDpThenBackwardDp;

/**
 * Created by yizhao on 5/18/15.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(A)); // 6
    }

    public static int trap(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] dpF = new int[n];
        int[] dpB = new int[n];

        dpF[0] = A[0];
        for (int i = 1; i < n; i++) {
            dpF[i] = Math.max(dpF[i - 1], A[i]);
        }

        dpB[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dpB[i] = Math.max(dpB[i + 1], A[i]);
        }

        int globalRes = 0;
        for (int i = 0; i < n; i++) {
            globalRes += Math.min(dpF[i], dpB[i]) - A[i];
        }
        return globalRes;
    }
}
