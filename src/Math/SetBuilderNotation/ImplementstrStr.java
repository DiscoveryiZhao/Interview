package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        System.out.println(strStr("", "")); // "", 0
        System.out.println(strStr("", "a")); // null, -1
        System.out.println(strStr("a", "")); // a, 0
        System.out.println(strStr("aaa", "a")); // aaa, 0
        System.out.println(strStr("aaa", "aa")); // aaa, 0
        System.out.println(strStr("aaa", "aaaa")); // null, -1
        System.out.println(strStr("mississippi", "a")); // null, -1
        System.out.println(strStr("mississippi", "issi")); // ississippi, 1
        System.out.println(strStr("abaabd", "abaabcabdabba")); // null, -1
        System.out.println(strStr("mississippi", "issip")); // issippi, 4
    }

    /* 自己做的 */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int m = haystack.length(), n = needle.length();
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < m) {
            int tmp_i = i;
            while (j < n && i < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            // 要先判断if (j == n)而不能先判断if (i >= m)
            if (j == n) {
                return tmp_i;
            }
            if (i >= m) {
                return -1;
            }

            // reset
            i = tmp_i;
            j = 0;
            // increment
            i++;
        }
        return -1;
    }

    /* 参考别人的 */
    public static int strStr2(String haystack, String needle) {
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

    /* 参考别人的 */
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
