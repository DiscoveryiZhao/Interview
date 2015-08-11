package Recursion.DFS.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 11/28/14.
 */
public class N_Queens {
    public static void main(String[] args) {
        List<String[]> result = solveNQueens(4);
        // [.Q.., ...Q, Q..., ..Q.]
        // [..Q., Q..., ...Q, .Q..]
        for (String[] s : result) {
            System.out.println(Arrays.toString(s));
        }
    }

    public static List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        dfs(n, res, new int[n], 0);
        return res;
    }

    public static void dfs(int n, List<String[]> res, int[] rowInCol, int depth) {
        if (depth == n) {
            String[] fourRows = new String[n];
            for (int i = 0; i < n; i++) {
                String oneRow = "";
                for (int j = 0; j < n; j++) {
                    if (j == rowInCol[i]) {
                        oneRow += "Q";
                    } else {
                        oneRow += ".";
                    }
                }
                fourRows[i] = oneRow;
            }
            res.add(fourRows);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(rowInCol, i, depth)) {
                    rowInCol[depth] = i;
                    dfs(n, res, rowInCol, depth + 1);
                }
            }
        }
    }

    public static boolean isValid(int[] rowInCol, int col, int depth) {
        for (int row = 0; row < depth; row++) {
            // if(rowInCol[row] == col) <- check col
            // if(Math.abs(rowInCol[row] - col) == (depth - row)) <- check diagonal
            if (rowInCol[row] == col || Math.abs(rowInCol[row] - col) == Math.abs(depth - row)) {
                return false;
            }
        }
        return true;
    }
}
