package Interviews.ThreatStream;

import java.util.HashMap;

/**
 * Created by yizhao on 7/30/15.
 */
public class ThreatStream2 {
    public static void main(String[] args) {
        /* test case 1 */
        HashMap<String, String> dict1 = new HashMap<>();
        dict1.put("a", "x");
        System.out.println(resolve("<%a%>", dict1)); // x

        /* test case 2 */
        HashMap<String, String> dict2 = new HashMap<>();
        dict2.put("a", "x");
        System.out.println(resolve("<%%>", dict2)); // <%%>

        /* test case 3 */
        HashMap<String, String> dict3 = new HashMap<>();
        dict3.put("a", "x");
        System.out.println(resolve("x<%a%>x", dict3)); // xxx

        /* test case 4 */
        HashMap<String, String> dict4 = new HashMap<>();
        dict4.put("b", "y");
        dict4.put("c", "z");
        System.out.println(resolve("aaaaa<%%>bbbbb<%b%>ccccc<%c%>", dict4)); // aaaaa<%%>bbbbbycccccz

        /* test case 5 */
        HashMap<String, String> dict5 = new HashMap<>();
        dict5.put("a", "x");
        dict5.put("b", "y");
        dict5.put("c", "z");
        System.out.println(resolve("aaaaa<%a%>bbbbb<%b%>ccccc<%c%>", dict5)); // aaaaaxbbbbbycccccz

        /* test case 6 */
        HashMap<String, String> dict6 = new HashMap<>();
        dict6.put("aa", "x");
        dict6.put("b", "y");
        dict6.put("c", "z");
        System.out.println(resolve("aaaaa<%aa%>bbbbb<%b%>ccccc<%c%>", dict6)); // aaaaaxbbbbbycccccz

        /* test case 7 */
        HashMap<String, String> dict7 = new HashMap<>();
        dict7.put("a", "x");
        System.out.println(resolve("aaaaa<%a%>bbbbb<%a%>ccccc<%a%>", dict7)); // aaaaaxbbbbbxcccccx

        /* test case 8 */
        HashMap<String, String> dict8 = new HashMap<>();
        dict8.put("a", "x");
        dict8.put("b", "y");
        dict8.put("c", "z");
        System.out.println(resolve("aaaaa<%dd%>bbbbb<%b%>ccccc<%c%>", dict8)); // aaaaa<%dd%>bbbbbycccccz
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
        * two pointers algorithm approach, so the variable would between the interval [left..right-1]
        * */
        int left = 0;
        int right = 0;

        while (right < n) {
            /*
            * define a loop to continue if <% has not yet found
            * */
            while (right < n && s.charAt(right) != '<' && right + 1 < n && s.charAt(right + 1) != '%') {
                right++;
            }

            if(right + 1 == n){
                result.append(s.substring(left, right + 1));
                return result.toString();
            }

            result.append(s.substring(left, right));
            right += 2;
            left = right;

            /*
            * define a loop to continue if %> has not yet found
            * */
            while (right < n && s.charAt(right) != '%' && right + 1 < n && s.charAt(right + 1) != '>') {
                right++;
            }

            /*
            * handles the edge case
            * if true then would handles the edge case for <%%> in test case 2
            * */
            if (left == right) {
                result.append(s.substring(right - 2, right + 2));
            } else {
                /*
                * handles the edge case
                * if true then the dictionary does not contains the variable, for example in test case 7
                * */
                if (dict.containsKey(s.substring(left, right)) == false) {
                    right += 2;
                    result.append(s.substring(left - 2, left));
                    result.append(s.substring(left, right));
                    left = right;
                    continue;
                } else {
                    result.append(dict.get(s.substring(left, right)));
                }
            }
            right += 2;
            left = right;
        }
        result.append(s.substring(left, right));
        return result.toString();
    }
}
