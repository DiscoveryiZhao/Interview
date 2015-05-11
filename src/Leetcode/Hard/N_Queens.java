package Leetcode.Hard;

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
        vectorTraversal(res, new int[n], 0, vm);
        return res;
    }

    private static void vectorTraversal(List<String[]> res, int[] rowInCol, int vi, int vm) {
        if (vi == vm) {
            output(vm, res, rowInCol);
        } else {
            domainTraversal(res, rowInCol, vi, vm);
        }
    }

    private static void domainTraversal(List<String[]> res, int[] rowInCol, int vi, int vm){
        for (int i = 0; i < vm; i++) {
            int si = i;
            if (NotToCutBranch(rowInCol, si, vi) == false) {
                rowInCol[vi] = si;
                vectorTraversal(res, rowInCol, vi + 1, vm);
            }
        }
    }

    public static boolean NotToCutBranch(int[] rowInCol, int si, int vi) {
        for (int row = 0; row < vi; row++) {
            // if(rowInCol[row] == col) <- check col
            // if(Math.abs(rowInCol[row] - col) == (depth - row)) <- check diagonal
            if (rowInCol[row] == si || Math.abs(rowInCol[row] - si) == Math.abs(vi - row)) {
                return true;
            }
        }
        return false;
    }

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
