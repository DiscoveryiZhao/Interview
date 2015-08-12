package Recursion.DFS.Others;

/**
 * Created by yizhao on 6/30/15.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board1 = {{'A', 'B'}, {'C', 'D'}};
        System.out.println(exist(board1, "ACDB")); // true
        char[][] board3 = {{'A'}};
        System.out.println(exist(board3, "AB")); // false
    }

    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, new boolean[board.length][board[0].length], i, j, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int depth) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(depth - 1)) {
            if (depth == word.length()) {
                return true;
            }
            char c = word.charAt(depth);
            visited[i][j] = true;

            if (dfs(board, word, visited, i - 1, j, depth + 1) || dfs(board, word, visited, i + 1, j, depth + 1) || dfs(board, word, visited, i, j - 1, depth + 1) || dfs(board, word, visited, i, j + 1, depth + 1)) { // P(n+1)
                return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
