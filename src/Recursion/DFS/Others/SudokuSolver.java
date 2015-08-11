package Recursion.DFS.Others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 8/9/15.
 */
public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        List<Integer> emptyBlocks = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    emptyBlocks.add(i * board[0].length + j);
                }
            }
        }

        dfs(board, emptyBlocks, 0);

    }

    public static boolean dfs(char[][] board, List<Integer> emptyBlocks, int depth) {
        if (depth == emptyBlocks.size()) {
            return true;
        }
        int oneDimArrayCoordinate = emptyBlocks.get(depth);
        int row = oneDimArrayCoordinate / board[0].length;
        int col = oneDimArrayCoordinate % board[0].length;
        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, num, row, col)) {
                board[row][col] = num;
                if (dfs(board, emptyBlocks, depth + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;

    }

    public static boolean isValid(char[][] board, char num, int row, int col) {
        for (int i = 0; i < 9; i++) {
            int row_2 = row / 3 * 3 + i / 3;
            int col_2 = col / 3 * 3 + i % 3;
            // check horizontal 9 blocks || check vertical 9 blocks || check 3 * 3 blocks
            if (board[row][i] == num || board[i][col] == num || board[row_2][col_2] == num) {
                return false;
            }
        }
        return true;
    }
}
