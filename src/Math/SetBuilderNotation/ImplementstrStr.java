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

    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        if(m == 0 && n == 0){
            return 0;
        }
        if(m == 0){
            return -1;
        }
        if(n == 0){
            return 0;
        }
        int result = -1;
        int i = 0;
        int j = 0;

        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                result = i;
                while(i < m && j < n && haystack.charAt(i) == needle.charAt(j)){
                    if(j + 1 == n){
                        return result;
                    }
                    i++;
                    j++;
                }
                i = result;
                result = -1;
                j = 0;
            }
            i++;
        }
        return result;
    }
}
