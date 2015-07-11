package RecursionBacktrackingAndExhaustive.JianZhi;

/**
 * Created by yizhao on 7/11/15.
 */
public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat")); // true
        System.out.println(isScramble("great", "rgtae")); // true
        System.out.println(isScramble("rgeat", "rgtae")); // true
        System.out.println(isScramble("abcd", "bdac")); // false
        System.out.println(isScramble("abc", "abd")); // false
    }

    public static boolean isScramble(String s1, String s2) {
        // DFS + Pruning
        int m = s1.length(), n = s2.length();
        if (s1.equals(s2)) {
            return true;
        } else {
            // Pruning
            if (!isPermutation(s1, s2)) {
                return false;
            }

            for (int i = 1; i < m; i++) {
                String s1l = s1.substring(0, i), s1r = s1.substring(i);
                String s2Forardl = s2.substring(0, i), s2Forwardr = s2.substring(i);
                String s2Backwardl = s2.substring(0, n - i), s2Backwardr = s2.substring(n - i);
                if (isScramble(s1l, s2Forardl) && isScramble(s1r, s2Forwardr)) {
                    return true;
                }
                if (isScramble(s1l, s2Backwardr) && isScramble(s1r, s2Backwardl)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isPermutation(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            hash[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (--hash[s2.charAt(i) - 'a'] < 0) {
                // not permutation, return false
                return false;
            }
        }
        return true;
    }
}
