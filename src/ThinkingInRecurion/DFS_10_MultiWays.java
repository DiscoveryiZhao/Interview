package ThinkingInRecurion;

import java.util.ArrayList;

/**
 * Created by yizhao on 11/22/14.
 */
public class DFS_10_MultiWays {
    public static void main(String[] args) {
        // [adg , adh, adi, aeg, aeh, aei , afg, afh, afi, bdg, bdh , bdi, beg, beh, bei, bfg , bfh, bfi, cdg, cdh, cdi , ceg, ceh, cei, cfg, cfh , cfi]
        System.out.println(F_Multi_Ways("234"));
    }

    /*
    * letterCombinations
    * */
    public static ArrayList<String> F_Multi_Ways(String digits) {
        char[][] table = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        ArrayList<String> res = new ArrayList<String>();
        dfs(digits, table, res, "", 0);
        return res;
    }


    public static void dfs(String digits, char[][] table, ArrayList<String> res, String tmp, int depth) {
        if (depth == digits.length()) {
            res.add(tmp);
        } else {
            multiWays(digits, table, res, tmp, depth);
        }
    }

    public static void multiWays(String digits, char[][] table, ArrayList<String> res, String tmp, int depth) {
        int button = digits.charAt(depth) - '0';
        for (int i = 0; i < table[button].length; i++) {
            dfs(digits, table, res, tmp + table[button][i], depth + 1);
        }
    }

}
