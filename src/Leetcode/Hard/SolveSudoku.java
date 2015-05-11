package Leetcode.Hard;

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
        char[] grapth = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int vm = emptyBlocks.size();
        vectorTraversal(board, emptyBlocks, grapth, 0, vm);
    }

    private static boolean vectorTraversal(char[][] board, ArrayList<Integer> emptyBlocks, char[] solutionSpace, int vi, int vm) {
        if (vi == vm) {
            return true;
        } else {
            if(domainTraversal(board, emptyBlocks, solutionSpace,vi,vm)){
                return true;
            }
            return false;
        }
    }

    private static boolean domainTraversal(char[][] board, ArrayList<Integer> emptyBlocks, char[] solutionSpace, int vi, int vm){
        int oneDimArrayCoordinate = emptyBlocks.get(vi);
        int row = oneDimArrayCoordinate / board[0].length;
        int col = oneDimArrayCoordinate % board[0].length;
        for (int i = 0; i < solutionSpace.length; i++) {
            char si = solutionSpace[i];
            if (NotToCutBranch(board, si, row, col) == false) {
                board[row][col] = si;
                if (vectorTraversal(board, emptyBlocks, solutionSpace, vi + 1, vm)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean NotToCutBranch(char[][] board, char si, int row, int col) {
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
}