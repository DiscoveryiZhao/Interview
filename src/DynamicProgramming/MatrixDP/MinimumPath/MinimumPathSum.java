package DynamicProgramming.MatrixDP.MinimumPath;

/**
 * Created by yizhao on 5/18/15.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] test1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // 21
        int[][] test2 = { { 1, 2 }, { 1, 1 } }; // 3
        System. out.println(minPathSum(test1)); // 21
        System. out.println(minPathSum(test2)); // 3
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // state: f[x][y]从起点走到x,y的最短路径
        int[][] f = new int[m][n];

        // intialize for worst case: f[0][0] = A[0][0]
        f[0][0] = grid[0][0];

        // intialize for worst case: f[i][0] = sum(0,0 -> i,0)
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        // intialize for worst case: f[0][i] = sum(0,0 -> 0,i)
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }

        // function: f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];
    }

//    public static int minPathSum(int[][] grid) {
//        if (grid == null){
//            return 0;
//        }
//            int m = grid.length , n = grid[0].length;
//            int[] dp = new int[n]; // can only choose size n! don't choose size m as dp size
//            for (int i = 0; i < m; i++){
//                for (int j = 0; j < n; j++) {
//                    if (i == 0 && j == 0) {
//                        dp[0] = grid[0][0];
//                    } else {
//                        if(i==0) dp[j] = grid[i][j] + dp[j - 1];
//                        if(j==0) dp[j] = grid[i][j] + dp[j];
//                        if(i>0 && j > 0) dp[j] = grid[i][j] + Math.min(dp[j-1], dp[j]);
//                        //dp [j] = grid[i][j] + Math.min((i > 0 ? dp[j] : Integer.MAX_VALUE), (j > 0 ? dp[j - 1] : Integer.MAX_VALUE));
//                    }
//                }
//            }
//            return dp[n - 1];
//    }
}
