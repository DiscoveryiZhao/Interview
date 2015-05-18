package DynamicProgramming.BinomialCoefficient;

/**
 * Created by yizhao on 5/18/15.
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length , n = obstacleGrid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        } else {
            if (obstacleGrid[0][0] == 1){
                return 0;
            }
            int[] dp = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // True if 格子 is not obstacle
                    if (obstacleGrid[i][j] == 0) {
                        if (i == 0 && j == 0) {
                            dp[j] = 1;
                        } else {
                            if (i == 0) dp[j] = dp[j-1];
                            if (j == 0) dp[j] = dp[j];
                            if (i > 0 && j > 0) dp[j] = dp[j - 1] + dp[j];
                            // dp [j] = (i > 0 ? dp[j] : 0) + (j > 0 ? dp[j - 1] : 0);
                        }


                    } else { // True if 格子  is obstacle
                        // 如果格子为障碍物，我们则要手动在一维DP数组里设为0。
                        dp[j] = 0;
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
