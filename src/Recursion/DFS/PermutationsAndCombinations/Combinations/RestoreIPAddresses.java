package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        // [255.255.11.135, 255.255.111.35]
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        helper(s, res, new ArrayList<String>(), 0);
        return res;
    }

    public static void helper(String s, List<String> res, List<String> tmp, int fieldCount) {
        if (tmp.size() == 4) {
            if(fieldCount != s.length()) {
                return;
            }

            StringBuffer sb = new StringBuffer();
            for(String num: tmp){
                sb.append(num);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        for (int i = fieldCount; i <= fieldCount + 3 && i < s.length(); i++) {
            String field = s.substring(fieldCount, i + 1);
            if (!isValid(field)) {
                continue;
            }
            tmp.add(field);
            helper(s, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }

    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0"); // to eliminate cases like "00", "10"
        }
        int digit = Integer.parseInt(s);
        return digit > 0 && digit <= 255;
    }
}
