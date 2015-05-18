package DynamicProgramming.Sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 5/18/15.
 */
public class WordBreak {
    public static void main(String[] args) {
        Set<String> test1 = new HashSet<String>();
        test1.add( "leet");
        test1.add( "code");
        System. out.println(wordBreak( "leetcode", test1)); // true

        Set<String> test2 = new HashSet<String>();
        test2.add("a" );
        System. out.println(wordBreak( "a", test2)); // true

        Set<String> test3 = new HashSet<String>();
        test3.add( "aaaa");
        test3.add( "aa");
        System. out.println(wordBreak( "aaaaaaa", test3)); // false

        Set<String> test4 = new HashSet<String>();
        test4.add( "a");
        test4.add( "b");
        System. out.println(wordBreak( "ab", test4)); // true

        Set<String> test5 = new HashSet<String>();
        test5.add( "pear");
        test5.add( "apple");
        test5.add( "peach");
        System. out.println(wordBreak( "apple", test5)); // true

        Set<String> test6 = new HashSet<String>();
        String[] test6StringA = { "cbc", "bcda" , "adb" , "ddca" , "bad" , "bbb" , "dad", "dac" , "ba" , "aa" , "bd" , "abab" , "bb" , "dbda" , "cb" , "caccc" , "d" , "dd" , "aadb", "cc" , "b" , "bcc" , "bcd" , "cd" , "cbca" , "bbd" , "ddd" , "dabb" , "ab" , "acd" , "a",
                "bbcc", "cdcbd" , "cada" , "dbca" , "ac" , "abacd" , "cba" , "cdb" , "dbac", "aada" , "cdcda" , "cdc" , "dbc" , "dbcb" , "bdb" , "ddbdd" , "cadaa" , "ddbc" , "babb" };
        for (String s : test6StringA)
            test6.add(s);
        System. out.println(wordBreak( "bccdbacdbdacddabbaaaadababadad" , test6)); // true

        Set<String> test7 = new HashSet<String>();
        test7.add( "a");
        test7.add( "b");
        System. out.println(wordBreak( "aabaaa", test7));// true

        Set<String> test8 = new HashSet<String>();
        test8.add( "a");
        test8.add( "c");
        System. out.println(wordBreak( "aaabaac", test8)); // false

        Set<String> test9 = new HashSet<String>();
        // "cat", "cats", "and", "sand", "dog"
        test9.add( "cat");
        test9.add( "cats");
        test9.add( "and");
        test9.add( "sand");
        test9.add( "dog");
        System. out.println(wordBreak( "catsanddog", test9)); // true
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        // return dfs (s, dict);
        return wordBreakDP(s, dict);
    }

    public static boolean wordBreakDP(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // case for s = ""
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dict.contains(s.substring(j, i)) && dp[j] ? true : dp[i];
            }
        }
        return dp[n];
    }

    public static boolean dfs(String s, Set<String> dict) {
        int n = s.length();
        if (n == 0) {
            return true ;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (dict.contains(s.substring(0, i + 1))) {
                    if (dfs(s.substring(i + 1), dict)) {
                        return true ;
                    }
                }
            }
        }
        return false ;
    }
}
