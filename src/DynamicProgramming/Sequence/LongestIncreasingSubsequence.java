package DynamicProgramming.Sequence;

/**
 * Created by yizhao on 5/18/15.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        // 输出：4
        int[] test1 = {5, 3, 4, 8, 6, 7};

        // 输出：6, the longest increasing subsequence are {0, 2, 6, 9, 13, 15} and
        // {0, 4, 6, 9, 11, 15}
        int[] test2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        System.out.println(longestincreasingsubsequenceLIS(test1)); // 4
        System.out.println(longestincreasingsubsequenceLIS(test2)); // 6
    }

    public static int longestincreasingsubsequenceLIS(int[] a) {
        int n = a.length;
        if (n == 0) {
            return 0;
        }

        // state:
        int[] dp = new int[n];

        // intialize for worst case:
        for (int i = 0; i < dp.length; i++) {
            // worst case for result of a[0..i-1] is no increasing subsequence in previous sequence,
            // so only count current num itself
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
