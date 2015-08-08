package DynamicProgramming.SequenceDP;

/**
 * Created by yizhao on 5/18/15.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(minCut("bb")); // 0
        System.out.println(minCut("aab")); // 1
        System.out.println(minCut("aabsdsa")); // 3
        System.out.println(minCut("dbabbc")); // 3
    }

    public static int minCut(String s) {
        boolean[][] palinTable = isPalindrome(s);
        int n = s.length();

        // state: f[i]”前i”个字符组成的子字符串需要最少几次cut(最少能被分割为多少个字符串-1)， 能够分隔成为各自都是回文串的
        int[] dp = new int[n + 1];

        // intialize for worst case: f[0] = -1, f[1]=0,f[2]=1 ... f[i] = i-1
        // 这里f[1]就是f[0]字符，只有一个字符，最坏的case就是一刀都不用切，所以是0
        // 这里f[2]就是f[0],f[1]字符，只有两个字符，最坏的case是需要切一刀
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }

        // function: f[i] = min(dp[j] + 1, dp[i]) when j < i && j..i-1这是一段回文串
        // f[j]代表reuse旧的，看下0..j-1的子字符串需要最少几次cut
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (palinTable[j][i - 1]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    // 区间型动态规划
    public static boolean[][] isPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                dp[start][start + length]
                        = dp[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
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
