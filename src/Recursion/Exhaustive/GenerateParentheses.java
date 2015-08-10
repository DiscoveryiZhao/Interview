package Recursion.Exhaustive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 8/9/15.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(0)); // []
        System.out.println(generateParenthesis(1)); // [()]
        System.out.println(generateParenthesis(2)); // [(()), ()()]
        System.out.println(generateParenthesis(3)); // [((())), (()()), (())(), ()(()), ()()()]
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    private static void dfs(List<String> res, String tmp, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(tmp);
            return;
        }
        if (l > r)
            return;
        if (l > 0) {
            dfs(res, tmp + "(", l - 1, r);
        }
        if (r > 0) {
            dfs(res, tmp + ")", l, r - 1);
        }
    }
}
