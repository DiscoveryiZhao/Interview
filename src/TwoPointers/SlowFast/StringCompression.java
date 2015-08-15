package TwoPointers.SlowFast;

/**
 * Created by yizhao on 6/30/15.
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(stringCompression("a")); // a1
        System.out.println(stringCompression("aab")); // a2b1
        System.out.println(stringCompression("aaabbcaa")); // a3b2c1a2
    }

    public static String stringCompression(String s) {
        int n = s.length();
        String res = "";
        int l = 0;
        while (l < n) {
            char c = s.charAt(l);
            res += c;
            int count = 1;
            int r = l + 1;
            while (r < n && c == s.charAt(r)) {
                count++;
                r++;
            }
            res += count;
            l = r;
        }
        return res;
    }
}
