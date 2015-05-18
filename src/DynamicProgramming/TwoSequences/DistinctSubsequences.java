package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System. out.println(numDistinct( "abcde", "ace" ));// 1
        System. out.println(numDistinct( "abcdce", "ace" )); // 2
        System. out.println(numDistinct( "xabcde", "ace" ));// 1
        System. out.println(numDistinct( "abcde", "xace" )); // 0
        System. out.println(numDistinct( "rabbbit", "rabbit" )); // 3
    }

    public static int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1; // Handles when both S == "" && T == ""
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i > 0 && j == 0) { // Handles when T = ""
                    dp[i][0] = 1;
                } else if (i > 0 && j > 0) {
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
