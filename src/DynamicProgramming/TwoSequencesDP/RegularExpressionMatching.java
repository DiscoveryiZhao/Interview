package DynamicProgramming.TwoSequencesDP;

/**
 * Created by yizhao on 5/18/15.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        // treat '*' as 1 and 2 are all true
        System.out.println(isMatch("aaa", "aa*")); // true

        // treat '*' as 0
        System.out.println(isMatch("aaa", "ab*")); // false
        System.out.println(isMatch("aba", "aa*")); // false
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // state:
        boolean[][] f = new boolean[m + 1][n + 1];
        // intialize for worst case: Handles when both s == "" && p == ""
        f[0][0] = true;
        // intialize for worst case: Handles when S = ""
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*' && f[0][i - 2]) {
                f[0][i] = true;
            }
            // f[0][i] = p.charAt(i - 1) == '*' && f[0][i - 2] ? true : f[0][i];
        }
        // function:
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (match(s.charAt(i - 1), p.charAt(j - 1))) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    // treat '*' as 0
                    f[i][j] = p.charAt(j - 1) == '*' && f[i][j - 2] ? true : f[i][j];
                    // treat '*' as 2, if we can treat * as 1 && match(s.charAt(i - 1), p.charAt(j - 2))
                    f[i][j] = p.charAt(j - 1) == '*' && match(s.charAt(i - 1), p.charAt(j - 2)) && f[i - 1][j] ? true : f[i][j];
                }
            }
        }
        return f[m][n];
    }

    public static boolean match(char a, char b) {
        return b == '.' || a == b;
    }
}
