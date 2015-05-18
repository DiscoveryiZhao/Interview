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
        int[] dpForwardMin = new int[n];
        int[] dpBackwordMax = new int[n];

        int localMinVal = a[0];
        for (int i = 1; i < n; i++) {
            localMinVal = Math. min(localMinVal + a[i], a[i]);
            dpForwardMin[i] = Math. min(dpForwardMin[i - 1], localMinVal);
        }

        int localMaxVal = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            localMaxVal = Math. max(localMaxVal + a[i], a[i]);
            dpBackwordMax[i] = Math. max(dpBackwordMax[i + 1], localMaxVal);
        }

        int globalMaxDiff = 0;
        for (int i = 0; i < n; i++) {
            globalMaxDiff = Math. max(globalMaxDiff, dpBackwordMax[i] - dpForwardMin[i]);
        }
        return globalMaxDiff;
    }
}
