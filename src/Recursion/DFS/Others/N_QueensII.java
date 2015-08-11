package Recursion.DFS.Others;

/**
 * Created by yizhao on 8/9/15.
 */
public class N_QueensII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4)); // 2
    }

    public static int res;

    public static int totalNQueens(int n) {
        res = 0;
        dfs(n, new int[n], 0);
        return res;
    }

    public static void dfs(int n, int[] rowInCol, int depth) {
        if (depth == n) {
            res++;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(rowInCol, i, depth)) {
                rowInCol[depth] = i;
                dfs(n, rowInCol, depth + 1);
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
