package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class EditDistance {
    public static void main(String[] args) {
        System. out.println(minDistance( "Saturday", "Sturday" )); // 1
        System. out.println(minDistance( "ab", "abcd" )); // 2
        System. out.println(minDistance( "Saturday", "Sunday" )); // 3
        System. out.println(minDistance( "abc", "abcd" )); // 1
        System. out.println(minDistance( "", "a" )); // 1
        System. out.println(minDistance( "", "aa" )); // 2
        System. out.println(minDistance( "", "ab" )); // 2
    }

    public static int minDistance(String S, String T) {
        int m = S.length(), n = T.length();
        // state:
        int dp[][] = new int[m + 1][n + 1];
        // intialize for worst case:
        dp[0][0] = 0; // Handles when both S == "" && T == ""
        // function:
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 && j > 0) { // Handles when S = ""
                    dp[0][j] = j;
                } else if (i > 0 && j == 0) { // Handles when T = ""
                    dp[i][0] = i;
                } else if (i > 0 && j > 0) {
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1]; // No edit operations are necessary
                    } else {
                        // Reuse S[0..i-1]T[0..j-2] result, then Delete T[j-1]
                        int delete = dp[i][j - 1] + 1;
                        // Reuse S[0..i-2]T[0..j-1] result, then Insert S[i-1] to T
                        int insert = dp[i - 1][j] + 1;
                        // Reuse S[0..i-1]T[0..j-1] result, then Replace S[i - 1] with T[j - 1]
                        int replace = dp[i - 1][j - 1] + 1;
                        dp[i][j] = Math. min(replace, Math.min (delete, insert));
                    }
                }
            }
        }
        return dp[m][n];
    }
}
