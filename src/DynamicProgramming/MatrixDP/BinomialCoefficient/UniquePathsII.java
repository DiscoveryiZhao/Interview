package DynamicProgramming.MatrixDP.BinomialCoefficient;

/**
 * Created by yizhao on 5/18/15.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        // state:
        int[][] f = new int[n][m];

        // intialize for worst case:
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                f[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                f[0][i] = 1;
            } else {
                break;
            }
        }

        // function:
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else {
                    f[i][j] = 0;
                }
            }
        }

        return f[n - 1][m - 1];
    }

//    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length , n = obstacleGrid[0].length;
//        if (m == 0 || n == 0) {
//            return 0;
//        } else {
//            if (obstacleGrid[0][0] == 1){
//                return 0;
//            }
//            int[] dp = new int[n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    // True if 格子 is not obstacle
//                    if (obstacleGrid[i][j] == 0) {
//                        if (i == 0 && j == 0) {
//                            dp[j] = 1;
//                        } else {
//                            if (i == 0) dp[j] = dp[j-1];
//                            if (j == 0) dp[j] = dp[j];
//                            if (i > 0 && j > 0) dp[j] = dp[j - 1] + dp[j];
//                            // dp [j] = (i > 0 ? dp[j] : 0) + (j > 0 ? dp[j - 1] : 0);
//                        }
//
//
//                    } else { // True if 格子  is obstacle
//                        // 如果格子为障碍物，我们则要手动在一维DP数组里设为0。
//                        dp[j] = 0;
//                    }
//                }
//            }
//            return dp[n - 1];
//        }
//    }
}
