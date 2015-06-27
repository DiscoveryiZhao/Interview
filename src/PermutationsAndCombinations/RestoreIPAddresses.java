package PermutationsAndCombinations;

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
        helper(s, res, "", 1);
        return res;
    }

    public static void helper(String s, List<String> res, String tmp, int fieldCount) {
        if (fieldCount == 4) {
            if (isValid(s)) {
                res.add(tmp + s);
            }
            return;
        }
        for (int i = 1; i <= 3 && i < s.length(); i++) {
            String field = s.substring(0, i);
            if (isValid(field)) {
                helper(s.substring(i), res, tmp + field + ".", fieldCount + 1);
            }
        }

    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }
}
