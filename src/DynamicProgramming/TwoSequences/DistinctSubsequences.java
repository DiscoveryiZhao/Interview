package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("abcde", "ace"));// 1
        System.out.println(numDistinct("abcdce", "ace")); // 2
        System.out.println(numDistinct("xabcde", "ace"));// 1
        System.out.println(numDistinct("abcde", "xace")); // 0
        System.out.println(numDistinct("rabbbit", "rabbit")); // 3
    }

    public static int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        // state: f[i][j] = S的前i个里面取出T的前j个字符，有多少种方案
        int[][] dp = new int[m + 1][n + 1];

        // intialize for worst case: Handles when T = ""
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = 1;
        }

        // function:
        // f[i][j] = f[i-1][j] + f[i-1][j-1] when S[i-1] == T[j-1]，S[i-1]和T[j-1]配对
        //         = f[i-1][j]               when S[i-1] != T[j-1]，S[i-1]和T[j-1]不配对
        // 这里f[i-1][j]代表我要S[i-1]中的某个字符和T[j]配对
        // 这里f[i-1][j-1]代表我要S[i-1]和T[j-1]配对
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
