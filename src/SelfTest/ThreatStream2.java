package SelfTest;

import java.util.HashMap;

/**
 * Created by yizhao on 7/30/15.
 */
public class ThreatStream2 {
    public static void main(String[] args) {
        String s = "aaaaa<%a%>bbbbb<%b%>ccccc<%c%>";
        HashMap<String, String> dict = new HashMap<>();
        dict.put("a", "x");
        dict.put("b", "y");
        dict.put("c", "z");

        // "aaaaa<%x%>bbbbb<%y%>ccccc<%z%>"

        resolve(s, dict);

    }

    public static String resolve(String s, HashMap<String, String> dict) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int l = 0;
        int r = 0;

        while (r < n) {
            while (r < n && s.charAt(r) != '<' && r < n + 1 && s.charAt(r + 1) != '%') {
                r++;
            }
            if (r == n) {
                result.append(s.substring(l, r));
                return result.toString();
            }

            r++;
            result.append(s.substring(l, r));
            l = r;
            while (r < n && s.charAt(r) != '%' && r < n + 1 && s.charAt(r + 1) != '>') {
                r++;
            }
            result.append(dict.get(s.substring(l + 1, r - 1)));
            r += 2;
            l = r;
        }
        result.append(s.substring(l, r));
        return result.toString();
    }
}
