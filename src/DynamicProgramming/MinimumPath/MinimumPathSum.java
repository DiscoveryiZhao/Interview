package DynamicProgramming.MinimumPath;

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
        if (grid == null){
            return 0;
        } else{
            int m = grid.length , n = grid[0].length;
            int[] dp = new int[n]; // can only choose size n! don't choose size m as dp size
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[0] = grid[0][0];
                    } else {
                        if(i==0) dp[j] = grid[i][j] + dp[j - 1];
                        if(j==0) dp[j] = grid[i][j] + dp[j];
                        if(i>0 && j > 0) dp[j] = grid[i][j] + Math.min(dp[j-1], dp[j]);
                        //dp [j] = grid[i][j] + Math.min((i > 0 ? dp[j] : Integer.MAX_VALUE), (j > 0 ? dp[j - 1] : Integer.MAX_VALUE));
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
