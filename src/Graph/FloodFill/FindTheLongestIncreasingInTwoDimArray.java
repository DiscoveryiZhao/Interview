package Graph.FloodFill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/30/15.
 */
public class FindTheLongestIncreasingInTwoDimArray {
    public static void main(String[] args) {
        int[][] board1 = {{99, 88, 77, 66, 55}, {44, 4, 5, 33, 22}, {999, 5, 6, 7, 888}, {777, 6, 7, 8, 666}, {555, 444, 8, 9, 10}};
        int[][] board2 = {{4, 3, 9}, {6, 5, 1}, {7, 8, 2}};
        int[][] board3 = {{4, 3, 9}, {6, 5, 8}, {7, 6, 7}};
        int[][] board4 = {{1, 5, 3}, {4, 10, 9}, {2, 8, 7}};
        System.out.println(longestIncreasingContinuousSubsequenceII(board1)); // [4, 5, 6, 7, 8, 9, 10]
        System.out.println(longestIncreasingContinuousSubsequenceII(board2)); // [5, 6, 7, 8]
        System.out.println(longestIncreasingContinuousSubsequenceII(board3)); // [5, 6, 7, 8, 9]
        System.out.println(longestIncreasingContinuousSubsequenceII(board4));
    }

    public static List<Integer> res;

    public static List<Integer> longestIncreasingContinuousSubsequenceII(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        } else {
            res = new ArrayList<>();
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, new ArrayList<Integer>(), visited, board[i][j] - 1, i, j);
                }
            }
            return res;
        }
    }

    private static void dfs(int[][] board, List<Integer> tmp, boolean[][] visited, int previousNum, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        if (board[i][j] > previousNum) {
            tmp.add(board[i][j]);
            visited[i][j] = true;
            if (tmp.size() > res.size()) {
                res = new ArrayList<>(tmp);
            }

            dfs(board, tmp, visited, board[i][j], i - 1, j);
            dfs(board, tmp, visited, board[i][j], i + 1, j);
            dfs(board, tmp, visited, board[i][j], i, j - 1);
            dfs(board, tmp, visited, board[i][j], i, j + 1);

            tmp.remove(tmp.size() - 1);
            visited[i][j] = false;
        }
    }
}
