package SelfTest;

import java.util.HashMap;

/**
 * Created by yizhao on 7/30/15.
 */
public class ThreatStream2 {
    public static void main(String[] args) {
        String s1 = "aaaaa<%a%>bbbbb<%b%>ccccc<%c%>";
        HashMap<String, String> dict1 = new HashMap<>();
        dict1.put("a", "x");
        dict1.put("b", "y");
        dict1.put("c", "z");
        System.out.println(resolve(s1, dict1)); // "aaaaa<%x%>bbbbb<%y%>ccccc<%z%>"


        String s2 = "aaaaa<%%>bbbbb<%b%>ccccc<%c%>";
        HashMap<String, String> dict2 = new HashMap<>();
        dict2.put("b", "y");
        dict2.put("c", "z");
        System.out.println(resolve(s2, dict2)); // "aaaaa<%%>bbbbb<%y%>ccccc<%z%>"


        String s3 = "<%a%>";
        HashMap<String, String> dict3 = new HashMap<>();
        dict3.put("a", "x");
        System.out.println(resolve(s3, dict3)); // "<%x%>"

    }

    public static String resolve(String s, HashMap<String, String> dict) {
        StringBuilder result = new StringBuilder();
        if(s == null || dict == null){
            return result.toString();
        }
        int n = s.length();
        int l = 0;
        int r = 0;

        while (r < n) {
            while (r < n && s.charAt(r) != '<' && r < n + 1 && s.charAt(r + 1) != '%') {
                r++;
            }
            if (r == n) {
                result.append(s.substring(l, r + 1));
                return result.toString();
            }

            r += 2;
            result.append(s.substring(l, r));
            l = r - 1;
            while (r < n && s.charAt(r) != '%' && r < n + 1 && s.charAt(r + 1) != '>') {
                r++;
            }

//            System.out.println("s.substring(l + 1, r):" + s.substring(l + 1, r) + "  ,l:" + l + "  ,r:" + r);
            result.append(dict.get(s.substring(l + 1, r)));
            r += 2;
            result.append(s.substring(r - 2, r));
            l = r;
        }
        result.append(s.substring(l, r));
        return result.toString();
    }
}
