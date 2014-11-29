package Leetcode.Backtracking;

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
        char[] solutionSpace = solutionSpaceSet();
        int vm = emptyBlocks.size();
        backtracking(board, emptyBlocks, solutionSpace, 0, vm);
    }

    public static boolean backtracking(char[][] board, ArrayList<Integer> emptyBlocks, char[] solutionSpace, int vi, int vm) {
        if (accept(vi, vm)) {
            return output();
        } else {
            int oneDimArrayCoordinate = emptyBlocks.get(vi);
            int row = oneDimArrayCoordinate / board[0].length;
            int col = oneDimArrayCoordinate % board[0].length;
            for (int i = 0; i < solutionSpace.length; i++) {
                char si = solutionSpace[i];
                if (reject(board, si, row, col) == false) {
                    first(board, si, row, col);
                    if (backtracking(board, emptyBlocks, solutionSpace, vi + 1, vm)) {
                        return true;
                    }
                    removingTrailingValueFromVector(board, row, col);
                }
            }
            return false;
        }
    }

    public static char[] solutionSpaceSet() {
        char[] solutionSpace = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        return solutionSpace;
    }

    // reject(P,c): return true only if the partial candidate c is not worth completing.
    public static boolean reject(char[][] board, char si, int row, int col) {
        for (int i = 0; i < 9; i++) {
            int row_2 = row / 3 * 3 + i / 3;
            int col_2 = col / 3 * 3 + i % 3;
            // check horizontal 9 blocks || check vertical 9 blocks || check 3 * 3 blocks
            if (board[row][i] == si || board[i][col] == si || board[row_2][col_2] == si) {
                return true;
            }
        }
        return false;
    }

    // accept(P,c): return true if c is a solution of P, and false otherwise.
    public static boolean accept(int vi, int size) {
        return vi == size;
    }

    // first(P,c): generate the first extension of candidate c.
    public static void first(char[][] board, char si, int row, int col) {
        board[row][col] = si;
    }

    public static void removingTrailingValueFromVector(char[][] board, int row, int col) {
        board[row][col] = '.';
    }

    // output(P,c): use the solution c of P, as appropriate to the application.
    public static boolean output() {
        return true;
    }
}
