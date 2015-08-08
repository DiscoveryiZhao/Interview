package DynamicProgramming.MatrixDP.BinomialCoefficient;

/**
 * Created by yizhao on 5/18/15.
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else {
            int[] dp = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j-1] + dp[j];
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
