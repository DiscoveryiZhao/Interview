package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class StringCompression {
    public static void main(String[] args) {
        System. out.println(stringCompression( "a")); // a1
        System. out.println(stringCompression( "aab")); // a2b1
        System. out.println(stringCompression( "aaabbcaa")); // a3b2c1a2
    }

    public static String stringCompression(String s) {
        int n = s.length();
        String res = "";
        int i = 0;
        while (i < n) {
            res += s.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < n && s.charAt(j - 1) == s.charAt(j)) {
                count++;
                j++;
            }
            res += count;
            i = j;
        }
        return res;
    }
}
