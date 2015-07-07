package SlidingWindow.UsingHash;

/**
 * Created by yizhao on 7/1/15.
 */
public class LongestSubstringWithoutRepeatingCharactersReturnCount {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a")); // 1
        System.out.println(lengthOfLongestSubstring("aa")); // 1
        System.out.println(lengthOfLongestSubstring("aab")); // 2
        System.out.println(lengthOfLongestSubstring("aaba")); // 2
        System.out.println(lengthOfLongestSubstring("ab")); // 2
        System.out.println(lengthOfLongestSubstring("abc")); // 3
        System.out.println(lengthOfLongestSubstring("aabbc")); // 2
        System.out.println(lengthOfLongestSubstring("abbcd")); // 3
        System.out.println(lengthOfLongestSubstring("bcadabcef")); // 6
        System.out.println(lengthOfLongestSubstring("abcabcabcabc")); // 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] hash = new boolean[256];
        int maxlen = 0;
        int L = 0;
        int R = 0;
        while (R < n) {
            // a[L..R-1] satisfy !hash[s.charAt(right)]
            while (R < n && !hash[s.charAt(R)]) hash[s.charAt(R++)] = true;
            maxlen = Math.max(maxlen, R - L);
            // find K
            while (R < n && s.charAt(L) != s.charAt(R)) hash[s.charAt(L++)] = false;
            L++;
            R++;
        }
        return maxlen;
    }
}
