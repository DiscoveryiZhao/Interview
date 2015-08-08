package DynamicProgramming.MatrixDP.BinomialCoefficient;

/**
 * Created by yizhao on 5/18/15.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        // state: f[x][y]从起点到x,y的路径数
        int[][] f = new int[m][n];

        // intialize for worst case: f[0][0] = 1 // f[0][i] = 1, f[i][0] = 1
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }

        // function: (研究倒数第一步) f[x][y] = f[x - 1][y] + f[x][y - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

//    public static int uniquePaths(int m, int n) {
//        if (m == 0 || n == 0) {
//            return 0;
//        } else {
//            int[] dp = new int[n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (i == 0 || j == 0) {
//                        dp[j] = 1;
//                    } else {
//                        dp[j] = dp[j-1] + dp[j];
//                    }
//                }
//            }
//            return dp[n - 1];
//        }
//    }
}
