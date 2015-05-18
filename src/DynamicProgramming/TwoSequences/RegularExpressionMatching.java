package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        // treat '*' as 1 and 2 are all true
        System. out.println(isMatch( "aaa", "aa*" )); // true

        // treat '*' as 0
        System. out.println(isMatch( "aaa", "ab*" )); // false
        System. out.println(isMatch( "aba", "aa*" )); // false
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Handles when both s == "" && p == ""
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j > 1) { // Handles when S = ""
                    dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2] ? true : dp[0][j];
                } else if (i > 0 && j > 0) {
                    if (match(s.charAt(i - 1), p.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // treat '*' as 0
                        dp[i][j] = p.charAt(j - 1) == '*' && dp[i][j - 2] ? true : dp[i][j];
                        // treat '*' as 2, if we can treat * as 1 && match(s.charAt(i - 1), p.charAt(j - 2))
                        dp[i][j] = p.charAt(j - 1) == '*' && match(s.charAt(i - 1), p.charAt(j - 2)) && dp[i - 1][j] ? true : dp[i][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean match(char a, char b) {
        return b == '.' || a == b;
    }
}
