package Graph.FloodFill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class SurroundedRegionsBFS {
    public static void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        } else {
            int rowLen = board.length , colLen = board[0].length;

            for (int j = 1; j < colLen - 1; j++) {
                // first row && second row
                if (board[0][j] == 'O' && board[1][j] == 'O') {
                    bfs(board, 1, j);
                }
                // last row && last last row
                if (board[rowLen - 1][j] == 'O' && board[rowLen - 2][j] == 'O') {
                    bfs(board, rowLen - 2, j);
                }
            }

            // first and last col
            for (int i = 1; i < rowLen - 1; i++) {
                // first col && second col
                if (board[i][0] == 'O' && board[i][1] == 'O') {
                    bfs(board, i, 1);
                }
                // last col && last last col
                if (board[i][colLen - 1] == 'O' && board[i][colLen - 2] == 'O') {
                    bfs(board, i, colLen - 2);
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

    private static void bfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O' ) {
            return;
        } else {
            Queue<Integer> queue = new LinkedList<Integer>();
            board[x][y] = '#';
            queue.offer(x * board[0]. length + y);
            while (!queue.isEmpty()) {
                int oneDimArrayCoordinate = queue.poll();
                int i = oneDimArrayCoordinate / board[0].length ;
                int j = oneDimArrayCoordinate % board[0].length ;
                // i - 1 > 0 instead of i - 1 >= 0 because we don't scan the first row
                if (i - 1 > 0 && board[i - 1][j] == 'O') {
                    board[i - 1][j] = '#';
                    queue.offer((i - 1) * board[0]. length + j);
                }

                // i + 1 < board.length - 1 instead of i + 1 < board.length because we don't scan the last row
                if (i + 1 < board.length - 1 && board[i + 1][j] == 'O') {
                    board[i + 1][j] = '#';
                    queue.offer((i + 1) * board[0]. length + j);
                }

                // j - 1 > 0 instead of j - 1 >= 0 because we don't scan the first column
                if (j - 1 > 0 && board[i][j - 1] == 'O') {
                    board[i][j - 1] = '#';
                    queue.offer(i * board[0]. length + (j - 1));
                }

                // j + 1 < board[0].length - 1 instead of j + 1 < board[0].length because we don't scan the last column
                if (j + 1 < board[0].length - 1 && board[i][j + 1] == 'O') {
                    board[i][j + 1] = '#';
                    queue.offer(i * board[0]. length + (j + 1));
                }
            }
        }
    }
}
