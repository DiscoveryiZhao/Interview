package Math.ProofbyContradiction;

/**
 * Created by yizhao on 6/30/15.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, board[i][j], i, j)) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static boolean isValid(char[][] board, char num, int row, int col) {
        for (int i = 0; i < 9; i++) {
            int row_2 = row / 3 * 3 + i / 3;
            int col_2 = col / 3 * 3 + i % 3;
            // check horizontal 9 blocks || check vertical 9 blocks || check 3 * 3 blocks
            if ((i != col && board[row][i] == num) || (i != row && board[i][col] == num) || (row_2 != row && col_2 != col && board[row_2][col_2] == num)) {
                return false;
            }
        }
        return true;
    }
}
