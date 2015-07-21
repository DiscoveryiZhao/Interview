package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class ImplementstrStr {
    public static void main(String[] args) {
        System.out.println(strStr("", "")); // ""
        System.out.println(strStr("", "a")); // null
        System.out.println(strStr("a", "")); // a
        System.out.println(strStr("aaa", "a")); // aaa
        System.out.println(strStr("aaa", "aa")); // aaa
        System.out.println(strStr("aaa", "aaaa")); // null
        System.out.println(strStr("mississippi", "a")); // null
        System.out.println(strStr("mississippi", "issi")); // ississippi
        System.out.println(strStr("abaabd", "abaabcabdabba")); // null
    }

    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < m - n + 1; i++) {
            int j = i;
            while (j < i + n && haystack.charAt(j) == needle.charAt(j - i)) {
                j++;
            }

            if (j == i + n) {
                return i;
            }
        }
        return -1;
    }

    public static String strStrOld(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) {
            return haystack;
        }
        for (int i = 0; i < m - n + 1; i++) {
            int j = i;
            while (j < i + n && haystack.charAt(j) == needle.charAt(j - i)) {
                j++;
            }

            if (j == i + n) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
