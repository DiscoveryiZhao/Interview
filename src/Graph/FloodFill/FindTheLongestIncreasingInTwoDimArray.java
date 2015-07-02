package Graph.FloodFill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 6/30/15.
 */
public class FindTheLongestIncreasingInTwoDimArray {
    public static void main(String[] args) {
        int[][] board1 = { { 99, 88, 77, 66, 55 }, { 44, 4, 5, 33, 22 }, { 999, 5, 6, 7, 888 }, { 777, 6, 7, 8, 666 }, { 555, 444, 8, 9, 10 } };
        int[][] board2 = { { 4, 3, 9 }, { 6, 5, 1 }, { 7, 8, 2 } };
        int[][] board3 = { { 4, 3, 9 }, { 6, 5, 8 }, { 7, 6, 7 } };
        System. out.println(solve(board1)); // [4, 5, 6, 7, 8, 9, 10]
        System. out.println(solve(board2)); // [5, 6, 7, 8]
        System. out.println(solve(board3)); // [5, 6, 7, 8, 9]
    }

    public static List<Integer> res;
    public static List<Integer> solve(int[][] board) {
        if (board.length == 0 || board[0].length == 0) { // P(0)
            return new ArrayList<>();
        } else {
            res = new ArrayList<>();
            boolean[][] visited = new boolean[board. length][board[0]. length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (isValidForOne(board, visited, i, j)) {
                        dfs(board, new ArrayList<Integer>(), visited, i, j);
                    }
                }
            }
            return res ;
        }
    }

    private static void dfs(int[][] board, List<Integer> tmp, boolean[][] visited, int i, int j) {
        tmp.add(board[i][j]); // P(n)
        visited[i][j] = true;
        if (!isValidForOne(board, visited, i, j) && tmp.size() > res.size()) {
            res = new ArrayList<Integer>(tmp);
        }

        if (isValidUp(board, visited, i, j)) {
            dfs(board, tmp, visited, i - 1, j);// P(n+1)
        }

        if (isValidDown(board, visited, i, j)) {
            dfs(board, tmp, visited, i + 1, j);// P(n+1)
        }

        if (isValidLeft(board, visited, i, j)) {
            dfs(board, tmp, visited, i, j - 1);// P(n+1)
        }

        if (isValidRight(board, visited, i, j)) {
            dfs(board, tmp, visited, i, j + 1);// P(n+1)
        }

        tmp.remove(tmp.size() - 1);
        visited[i][j] = false;
    }

    public static boolean isValidForOne(int[][] board, boolean[][] visited, int i, int j) {
        return isValidUp(board, visited, i, j) || isValidDown(board, visited, i, j) || isValidLeft(board, visited, i, j) || isValidRight(board, visited, i, j);
    }

    public static boolean isValidUp(int[][] board, boolean[][] visited, int i, int j) {
        return (i - 1 >= 0 && board[i][j] + 1 == board[i - 1][j]) && !visited[i - 1][j];
    }

    public static boolean isValidDown(int[][] board, boolean[][] visited, int i, int j) {
        return (i + 1 < board.length && board[i][j] + 1 == board[i + 1][j]) && !visited[i + 1][j];
    }

    public static boolean isValidLeft(int[][] board, boolean[][] visited, int i, int j) {
        return (j - 1 >= 0 && board[i][j] + 1 == board[i][j - 1]) && !visited[i][j - 1];
    }

    public static boolean isValidRight(int[][] board, boolean[][] visited, int i, int j) {
        return (j + 1 < board[0].length && board[i][j] + 1 == board[i][j + 1]) && !visited[i][j + 1];
    }
}
