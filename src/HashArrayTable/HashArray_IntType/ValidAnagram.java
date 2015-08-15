package HashArrayTable.HashArray_IntType;

/**
 * Created by yizhao on 12/12/14.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cba")); // true
        System.out.println(isAnagram("abc", "cda")); // false
    }

    public static boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < m; i++) {
            hash[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            hash[t.charAt(i) - 'a']--;
            if (hash[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
