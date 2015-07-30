package SelfTest;

import java.util.HashMap;

/**
 * Created by yizhao on 7/30/15.
 */
public class ThreatStream2 {
    public static void main(String[] args) {
        HashMap<String, String> dict1 = new HashMap<>();
        dict1.put("a", "x");
        System.out.println(resolve("<%a%>", dict1)); // x

        HashMap<String, String> dict2 = new HashMap<>();
        dict2.put("a", "x");
        System.out.println(resolve("<%%>", dict2)); // <%%>

        HashMap<String, String> dict3 = new HashMap<>();
        dict3.put("b", "y");
        dict3.put("c", "z");
        System.out.println(resolve("aaaaa<%%>bbbbb<%b%>ccccc<%c%>", dict3)); // aaaaabbbbbycccccz

        HashMap<String, String> dict4 = new HashMap<>();
        dict4.put("a", "x");
        dict4.put("b", "y");
        dict4.put("c", "z");
        System.out.println(resolve("aaaaa<%a%>bbbbb<%b%>ccccc<%c%>", dict4)); // aaaaaxbbbbbycccccz

        HashMap<String, String> dict5 = new HashMap<>();
        dict5.put("aa", "x");
        dict5.put("b", "y");
        dict5.put("c", "z");
        System.out.println(resolve("aaaaa<%aa%>bbbbb<%b%>ccccc<%c%>", dict5)); // aaaaaxbbbbbycccccz

        HashMap<String, String> dict6 = new HashMap<>();
        dict6.put("a", "x");
        System.out.println(resolve("aaaaa<%a%>bbbbb<%a%>ccccc<%a%>", dict6)); // aaaaaxbbbbbxcccccx

        HashMap<String, String> dict7 = new HashMap<>();
        dict7.put("a", "x");
        dict7.put("b", "y");
        dict7.put("c", "z");
        System.out.println(resolve("aaaaa<%dd%>bbbbb<%b%>ccccc<%c%>", dict7)); // aaaaa<%dd%>bbbbbycccccz
    }

    public static String resolve(String s, HashMap<String, String> dict) {
        StringBuilder result = new StringBuilder();
        if (s == null || dict == null) {
            return result.toString();
        }
        if (dict.size() == 0) {
            return s;
        }
        int n = s.length();

        /*
        * two pointers algorithm approach, so the variable would between the interval [l..r]
        * */
        int l = 0;
        int r = 0;

        while (r < n) {
            /*
            * define a loop to contine if <% has not yet found
            * */
            while (r < n && s.charAt(r) != '<' && r < n + 1 && s.charAt(r + 1) != '%') {
                r++;
            }

            r += 2;
            result.append(s.substring(l, r - 2));
            l = r;

            /*
            * define a loop to contine if %> has not yet found
            * */
            while (r < n && s.charAt(r) != '%' && r < n + 1 && s.charAt(r + 1) != '>') {
                r++;
            }

            /*
            * handles the edge case
            * if true then would handles the edge case for <%%>
            * */
            if (l == r) {
                result.append(s.substring(r - 2, r + 2));
            } else {
                /*
                * handles the edge case
                * if true then the dictionary does not contains the variable
                * */
                if (dict.containsKey(s.substring(l, r)) == false) {
                    r += 2;
                    result.append(s.substring(l - 2, l));
                    result.append(s.substring(l, r));
                    l = r;
                    continue;
                } else {
                    result.append(dict.get(s.substring(l, r)));
                }
            }
            r += 2;
            l = r;
        }
        result.append(s.substring(l, r));
        return result.toString();
    }
}
