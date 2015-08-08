package DynamicProgramming.Sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yizhao on 5/18/15.
 */
public class WordBreakII {
    public static void main(String[] args) {
        Set<String> test9 = new HashSet<String>();

        test9.add( "cat");
        test9.add( "cats");
        test9.add( "and");
        test9.add( "sand");
        test9.add( "dog");
        System. out.println(wordBreak( "catsanddog", test9)); // [cat sand dog, cats and dog]

        String[] tmp = { "a", "aa" , "aaa" , "aaaa" , "aaaaa" , "aaaaaa" , "aaaaaaa" , "aaaaaaaa", "aaaaaaaaa" , "aaaaaaaaaa" };
        Set<String> test10 = new HashSet<String>();
        for (String s : tmp) {
            test10.add(s);
        }

        System. out.println(wordBreak( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" , test10)); // true
    }

    public static List<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        // state: f[i]表示“前i”个字符能否被完美切分
        boolean[] dp = new boolean[n + 1]; //
        // intialize for worst case: case for s = ""
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dict.contains(s.substring(j, i)) && dp[j] ? true : dp[i];
            }
        }
        // This problem can not be solve because dp[n] is false
        if (dp[n] == false) {
            return res;
        }
        dfs(s, dict, res, "" );
        return res;
    }

    private static void dfs(String s, Set<String> dict, List<String> res, String tmp) {
        int n = s.length();
        if (n == 0) {
            // tmp.length() - 1 use to remove the last " " in tmp String.
            res.add(tmp.substring(0, tmp.length() - 1));
        } else {
            for (int i = 1; i <= n; i++) {
                String soFar = s.substring(0, i);
                if (dict.contains(soFar)) {
                    dfs(s.substring(i), dict, res, tmp + soFar + " ");
                }
            }
        }
    }
}
