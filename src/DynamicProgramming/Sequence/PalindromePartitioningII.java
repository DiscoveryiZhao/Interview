package DynamicProgramming.Sequence;

/**
 * Created by yizhao on 5/18/15.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        System. out.println(minCut( "bb")); // 0
        System. out.println(minCut( "aab")); // 1
        System. out.println(minCut( "aabsdsa")); // 3
        System. out.println(minCut( "dbabbc")); // 3
    }

    public static int minCut(String s) {
        boolean[][] palinTable = isPalindrome(s);
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // worst case for result of s[0..i-1] is no palindrome in previous string except char itself,
            // so the worst case is cutting by each char
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (palinTable[j][i - 1]) {
                    dp[i] = Math. min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] - 1;
    }

    public static boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // single char is the palindrome of itself, so set all dp[i][i] = true

            // even case
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                dp[l--][r++] = dp[i][i];
            }
            // odd case
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                dp[l--][r++] = dp[i][i];
            }
        }
        return dp;
    }


/*
    // overtime version
    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // worst case for result of s[0..i-1] is no palindrome in previous string except char itself,
            // so the worst case is cutting by each char
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s,j,i-1)) {
                    dp[i] = Math. min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] - 1;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
*/
}
