package DynamicProgramming.LocalOptimalSolutionThenGlobalOptimalSolution;

/**
 * Created by yizhao on 5/18/15.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        String opt = s.substring(0, 1);
        String sub = s.substring(0, 1);
        for (int i = 1; i < n; i++) {
            // odd length
            sub = getLongestPalindrome(s, i, i);
            if (sub.length() > opt.length()) {
                opt = sub;
            }

            // even length
            sub = getLongestPalindrome(s, i - 1, i);
            if (sub.length() > opt.length()) {
                opt = sub;
            }
        }
        return opt;
    }

    public static String getLongestPalindrome(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
