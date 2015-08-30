package DynamicProgramming.ForwardDpThenBackwardDp;

/**
 * Created by yizhao on 5/18/15.
 */
public class MaximumDifference {
    public static void main(String[] args) {
        int[] a = { 3, -5, 1, -2, 8, -2, 3, -2, 1 };
        System. out.println(maxdiff(a)); // 15
    }

    public static int maxdiff(int[] a) {
        int n = a.length ;
        int[] dpF = new int[n];
        int[] dpB = new int[n];

        int localMinVal = a[0];
        for (int i = 1; i < n; i++) {
            localMinVal = Math. min(localMinVal + a[i], a[i]);
            dpF[i] = Math. min(dpF[i - 1], localMinVal);
        }

        int localMaxVal = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            localMaxVal = Math. max(localMaxVal + a[i], a[i]);
            dpB[i] = Math. max(dpB[i + 1], localMaxVal);
        }

        int globalMaxDiff = 0;
        for (int i = 0; i < n; i++) {
            globalMaxDiff = Math. max(globalMaxDiff, dpB[i] - dpF[i]);
        }
        return globalMaxDiff;
    }
}
