package Leetcode.Backtracking;

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
        List<String[]> res = new ArrayList<String[]>();
        int vm = n;
        backtracking(res, new int[n], 0, vm);
        return res;
    }

    public static void backtracking(List<String[]> res, int[] rowInCol, int vi, int vm) {
        if (accept(vi, vm)) {
            output(vm, res, rowInCol);
        } else {
            for (int i = 0; i < vm; i++) {
                int si = i;
                if (reject(rowInCol, si, vi) == false) {
                    first(si, rowInCol, vi);
                    backtracking(res, rowInCol, vi + 1, vm);
                }
            }
        }
    }


    public static void solutionSpaceSet() {

    }

    // reject(P,c): return true only if the partial candidate c is not worth completing.
    public static boolean reject(int[] rowInCol, int si, int vi) {
        for (int row = 0; row < vi; row++) {
            // if(rowInCol[row] == col) <- check col
            // if(Math.abs(rowInCol[row] - col) == (depth - row)) <- check diagonal
            if (rowInCol[row] == si || Math.abs(rowInCol[row] - si) == Math.abs(vi - row)) {
                return true;
            }
        }
        return false;
    }

    // accept(P,c): return true if c is a solution of P, and false otherwise.
    public static boolean accept(int vi, int vm) {
        return vi == vm;
    }

    // first(P,c): generate the first extension of candidate c.
    public static void first(int si, int[] rowInCol, int vi) {
        rowInCol[vi] = si;
    }

    public static void removingTrailingValueFromVector() {

    }

    // output(P,c): use the solution c of P, as appropriate to the application.
    public static void output(int vm, List<String[]> res, int[] rowInCol) {
        String[] fourRows = new String[vm];
        for (int i = 0; i < vm; i++) {
            String oneRow = "";
            for (int j = 0; j < vm; j++) {
                if (j == rowInCol[i]) {
                    oneRow += "Q";
                } else {
                    oneRow += ".";
                }
            }
            fourRows[i] = oneRow;
        }
        res.add(fourRows);
    }
}
