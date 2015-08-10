package Recursion.PermutationsAndCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        // [[a, a, b, s, d, s, a], [a, a, b, sds, a], [aa, b, s, d, s, a], [ aa, b, sds, a]]
        System.out.println(partition("aabsdsa"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, res, new ArrayList<String>());
        return res;
    }

    public static void helper(String s, List<List<String>> res, List<String> tmp) {
        int n = s.length();
        if (n == 0) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        for (int i = 1; i <= n; i++) {
            String sofar = s.substring(0, i);
            if (isPalindrome(sofar)) {
                tmp.add(sofar);
                helper(s.substring(i), res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

}
