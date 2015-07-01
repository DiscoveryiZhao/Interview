package Graph.FloodFill;

/**
 * Created by yizhao on 6/30/15.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board1 = { { 'A' , 'B' }, { 'C' , 'D' } };
        System. out.println(exist(board1, "ACDB")); // true
        char[][] board3 = { { 'A' } };
        System. out.println(exist(board3, "AB")); // false
    }

    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true ;
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // true if found the starting char
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, word, new boolean[board.length ][board[0].length], i, j, 1)) {
                            return true ;
                        }
                    }
                }
            }
            return false ;
        }
    }

    private static boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int depth) {
        if (depth == word.length()) {
            return true ;
        } else {
            // P(n)
            char c = word.charAt(depth);
            visited[i][j] = true;

            if (i - 1 >= 0 && board[i - 1][j] == c && !visited[i - 1][j]) {
                if (dfs(board, word, visited, i - 1, j, depth + 1)) { // P(n+1)
                    return true ;
                }
            }

            if (i + 1 < board.length && board[i + 1][j] == c && !visited[i + 1][j]) {
                if (dfs(board, word, visited, i + 1, j, depth + 1)) { // P(n+1)
                    return true ;
                }
            }

            if (j - 1 >= 0 && board[i][j - 1] == c && !visited[i][j - 1]) {
                if (dfs(board, word, visited, i, j - 1, depth + 1)) { // P(n+1)
                    return true ;
                }
            }

            if (j + 1 < board[0].length && board[i][j + 1] == c && !visited[i][j + 1]) {
                if (dfs(board, word, visited, i, j + 1, depth + 1)) { // P(n+1)
                    return true ;
                }
            }

            visited[i][j] = false;
            return false ;
        }
    }
}
