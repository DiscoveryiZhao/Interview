package ThinkingInRecurion;

import java.util.ArrayList;

/**
 * Created by yizhao on 11/22/14.
 */
public class DFS_01_Left_Right_Ways {
    public static void main(String[] args) {
        System.out.println(F_left_right_ways("00*1*0")); // [000100, 000110, 001100, 001110]
    }


    /*
    * combinationStar
    * */
    public static ArrayList<String> F_left_right_ways(String s) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(s.toCharArray(), res, 0);
        return res;
    }


    public static void dfs(char[] sc, ArrayList<String> res, int depth) {
        if (depth == sc.length) {
            res.add(new String(sc));
        } else {
            if (sc[depth] == '*') {
                leftWay(sc, res, depth);
                rightWay(sc, res, depth);
                sc[depth] = '*';
            } else {
                dfs(sc, res, depth + 1);
            }
        }
    }

    public static void leftWay(char[] sc, ArrayList<String> res, int depth) {
        sc[depth] = '0';
        dfs(sc, res, depth + 1);
    }

    public static void rightWay(char[] sc, ArrayList<String> res, int depth) {
        sc[depth] = '1';
        dfs(sc, res, depth + 1);
    }
}

