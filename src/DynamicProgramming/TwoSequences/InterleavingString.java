package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";

        System.out.println(isInterleave(s1, s2, "aadbbcbcac")); // true
        System.out.println(isInterleave(s1, s2, "aadbbbaccc")); // false
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        // state: f[i][j]代表s1的前i个字符和s2的前j个字符能否交替组成s3的前i+j个字符
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        // intialize for worst case: Handles when both s1 == "" && s2 == ""
        dp[0][0] = true;

        // intialize for worst case: Handles when s2 = ""
        for (int i = 1; i <= s1.length(); i++) {
            if (dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }

        // intialize for worst case: Handles when s1 = ""
        for (int j = 1; j <= s2.length(); j++) {
            if (dp[0][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1)) {
                dp[0][j] = true;
            }
        }

        // function: f[i][j] = f[i-1][j]&&(s1[i-1]==s3[i+j-1]) || f[i][j-1]&&(s2[j-1]==s3[i+j-1])
        // f[i-1][j]代表s1的前i-1的字符和s2的前j的字符
        // f[i][j-1]代表s1的前i的字符和s2的前j-1的字符
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if ((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i - 1 + j))) {
                    dp[i][j] = true;
                }
//                dp[i][j] = s1.charAt(i - 1) == s3.charAt(i - 1 + j) && dp[i - 1][j] ? true : dp[i][j];
//                dp[i][j] = s2.charAt(j - 1) == s3.charAt(i - 1 + j) && dp[i][j - 1] ? true : dp[i][j];
            }
        }
        return dp[n1][n2];
    }
}
