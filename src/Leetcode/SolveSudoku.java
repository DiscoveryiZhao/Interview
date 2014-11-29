package Leetcode;

import java.util.ArrayList;

/**
 * Created by yizhao on 11/28/14.
 */
public class SolveSudoku {
    public static void solveSudoku(char[][] board) {
        ArrayList<Integer> emptyBlocks = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    emptyBlocks.add(i * board[0].length + j);
                }
            }
        }
        char[] vs = vectorSpace();
        backtracking(board, emptyBlocks, vs, 0);
    }

    public static boolean backtracking(char[][] board, ArrayList<Integer> emptyBlocks, char[] vs, int depth) {
        if (accept(depth, emptyBlocks.size())) {
            return output();
        } else {
            int oneDimArrayCoordinate = emptyBlocks.get(depth);
            int row = oneDimArrayCoordinate / board[0].length;
            int col = oneDimArrayCoordinate % board[0].length;
            for (int i = 0;i<vs.length;i++) {
                char vi = vs[i];
                if (reject(board, vi, row, col) == false) {
                    first(board, vi, row, col);
                    if (backtracking(board, emptyBlocks, vs, depth + 1)) {
                        return true;
                    }
                    removingTrailingValueFromVector(board, row, col);
                }
            }
            return false;
        }
    }

    public static char[] vectorSpace() {
        char[] vs = {'1','2','3','4','5','6','7','8','9'};
        return vs;
    }

    // reject(P,c): return true only if the partial candidate c is not worth completing.
    public static boolean reject(char[][] board, char v, int row, int col) {
        for (int i = 0; i < 9; i++) {
            int row_2 = row / 3 * 3 + i / 3;
            int col_2 = col / 3 * 3 + i % 3;
            // check horizontal 9 blocks || check vertical 9 blocks || check 3 * 3 blocks
            if (board[row][i] == v || board[i][col] == v || board[row_2][col_2] == v) {
                return true;
            }
        }
        return false;
    }

    // accept(P,c): return true if c is a solution of P, and false otherwise.
    public static boolean accept(int depth, int size) {
        return depth == size;
    }

    // first(P,c): generate the first extension of candidate c.
    public static void first(char[][] board, char v, int row, int col) {
        board[row][col] = v;
    }

    public static void removingTrailingValueFromVector(char[][] board, int row, int col){
        board[row][col] = '.';
    }

    // output(P,c): use the solution c of P, as appropriate to the application.
    public static boolean output() {
        return true;
    }
}
