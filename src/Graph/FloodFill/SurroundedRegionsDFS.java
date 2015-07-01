package Graph.FloodFill;

/**
 * Created by yizhao on 6/30/15.
 */
public class SurroundedRegionsDFS {
    public static void main(String[] args) {
        char[][] board1 = { { 'X' , 'X' , 'X' , 'X' }, { 'X' , 'O' , 'O' , 'X' }, { 'X' , 'X', 'O' , 'X' }, { 'X' , 'O' , 'X' , 'X' } };
        char[][] board2 = { { 'X' , 'X' , 'X' , 'X' }, { 'X' , 'O' , 'O' , 'X' }, { 'X' , 'O', 'O' , 'X' }, { 'X' , 'X' , 'O' , 'X' } };

        solve(board1);
        // XXXX
        // XXXX
        // XXXX
        // XOXX
        for (char [] b : board1) {
            System. out.println(b);
        }

        solve(board2);
        // XXXX
        // XOOX
        // XOOX
        // XXOX
        for (char [] b : board2) {
            System. out.println(b);
        }
    }

    public static void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) { // P(0)
            return;
        } else {
            int rowLen = board.length , colLen = board[0].length;
            for (int j = 1; j < colLen - 1; j++) {
                // first row && second row
                if (board[0][j] == 'O' && board[1][j] == 'O') {
                    dfs(board, 1, j); // P(2)
                }
                // last row && last last row
                if (board[rowLen - 1][j] == 'O' && board[rowLen - 2][j] == 'O') {
                    dfs(board, rowLen - 2, j); // P(2)
                }
            }

            // first and last col
            for (int i = 1; i < rowLen - 1; i++) {
                // first col && second col
                if (board[i][0] == 'O' && board[i][1] == 'O') {
                    dfs(board, i, 1);
                }
                // last col && last last col
                if (board[i][colLen - 1] == 'O' && board[i][colLen - 2] == 'O') {
                    dfs(board, i, colLen - 2); // P(2)
                }
            }

            // flip
            for (int i = 1; i < rowLen - 1; i++) {
                for (int j = 1; j < colLen - 1; j++) {
                    if (board[i][j] == 'O' ) {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = '#'; // P(n)
        // We don't need base case here, because before we do P(n+1) we already checked n+1
        // i - 1 > 0 instead of i - 1 >= 0 because we don't scan the first row
        if (i - 1 > 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j); // P(n+1)
        }
        // i + 1 < board.length - 1 instead of i + 1 < board.length because we don't scan the last row
        if (i + 1 < board.length - 1 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j); // P(n+1)
        }
        // j - 1 > 0 instead of j - 1 >= 0 because we don't scan the first column
        if (j - 1 > 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1); // P(n+1)
        }
        // j + 1 < board[0].length - 1 instead of j + 1 < board[0].length because we don't scan the last column
        if (j + 1 < board[0].length - 1 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1); // P(n+1)
        }
    }
}
