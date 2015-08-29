package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/26/15.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        // [[a, a, b, s, d, s, a], [a, a, b, sds, a], [aa, b, s, d, s, a], [ aa, b, sds, a]]
        //System.out.println(partition("aabsdsa"));

        // [[a, b, c]]
        System.out.println(partition("1234"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        traversal(s, res, new ArrayList<String>(), 0);
        return res;
    }

    public static void traversal(String s, List<List<String>> res, List<String> tmp, int depth) {
        int n = s.length();
        if (depth == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = depth; i < n; i++) {
//            prefix:1
//            prefix:2
//            prefix:3
//            prefix:4
//            prefix:34
//            prefix:23
//            prefix:234
//            prefix:12
//            prefix:123
//            prefix:1234
            String prefix = s.substring(depth, i + 1);
            if (!isPalindrome(prefix)) {
                continue;
            }
            tmp.add(prefix);
            traversal(s, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

//    public static List<List<String>> partition(String s) {
//        List<List<String>> res = new ArrayList<>();
//        traversal(s, res, new ArrayList<String>());
//        return res;
//    }
//
//    public static void traversal(String s, List<List<String>> res, List<String> tmp) {
//        int n = s.length();
//        if (n == 0) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//        for (int i = 1; i <= n; i++) {
//            String prefix  = s.substring(0, i);
//            if (isPalindrome(prefix)) {
//                tmp.add(prefix);
//                traversal(s.substring(i), res, tmp);
//                tmp.remove(tmp.size() - 1);
//            }
//        }
//    }
//
//    public static boolean isPalindrome(String s) {
//        int i = 0;
//        int j = s.length() - 1;
//        while (i < j) {
//            if (s.charAt(i++) != s.charAt(j--)) {
//                return false;
//            }
//        }
//        return true;
//    }

}
