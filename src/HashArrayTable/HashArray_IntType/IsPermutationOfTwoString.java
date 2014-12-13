package HashArrayTable.HashArray_IntType;

/**
 * Created by yizhao on 12/12/14.
 */
public class IsPermutationOfTwoString {
    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "cba")); // true
        System.out.println(isPermutation("abc", "cda")); // false
    }

    public static boolean isPermutation(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        } else {
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
}
