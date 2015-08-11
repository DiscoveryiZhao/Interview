package Recursion.DFS.PermutationsAndCombinations.Combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yizhao on 6/26/15.
 */
public class WordBreakII {
    public static void main(String[] args) {
        Set<String> test9 = new HashSet<>();

        test9.add("cat");
        test9.add("cats");
        test9.add("and");
        test9.add("sand");
        test9.add("dog");
        System.out.println(wordBreak("catsanddog", test9)); // [cat sand dog, cats and dog]

        String[] tmp = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        Set<String> test10 = new HashSet<String>();
        for (String s : tmp) {
            test10.add(s);
        }

        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", test10)); // true
    }

    public static List<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // case for s = ""
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i)) ? true : dp[i];
            }
        }
        // This problem can not be solve because dp[n] is false
        if (dp[n] == false) {
            return res;
        }
        helper(s, dict, res, new ArrayList<String>(), 0);
        return res;
    }

    private static void helper(String s, Set<String> dict, List<String> res, List<String> tmp, int pos) {
        int n = s.length();
        if (pos == s.length()) {
            // tmp.length() - 1 use to remove the last " " in tmp String.
            StringBuilder sb = new StringBuilder();
            for(String letter : tmp){
                sb.append(letter);
            }
            res.add(sb.toString());
        } else {
            for (int i = pos; i < n; i++) {
                String soFar = s.substring(pos, i + 1);
                if (!dict.contains(soFar)) {
                    continue;
                }
                tmp.add(soFar);
                helper(s, dict, res, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

//    public static List<String> wordBreak(String s, Set<String> dict) {
//        int n = s.length();
//        ArrayList<String> res = new ArrayList<String>();
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true; // case for s = ""
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < i; j++) {
//                dp[i] = dp[j] && dict.contains(s.substring(j, i)) ? true : dp[i];
//            }
//        }
//        // This problem can not be solve because dp[n] is false
//        if (dp[n] == false) {
//            return res;
//        }
//        helper(s, dict, res, "");
//        return res;
//    }
//
//    private static void helper(String s, Set<String> dict, ArrayList<String> res, String tmp) {
//        int n = s.length();
//        if (n == 0) {
//            // tmp.length() - 1 use to remove the last " " in tmp String.
//            res.add(tmp.substring(0, tmp.length() - 1));
//        } else {
//            for (int i = 1; i <= n; i++) {
//                String soFar = s.substring(0, i);
//                if (dict.contains(soFar)) {
//                    helper(s.substring(i), dict, res, tmp + soFar + " ");
//                }
//            }
//        }
//    }
}
