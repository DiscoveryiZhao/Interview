package Graph.FloodFill;

/**
 * Created by yizhao on 6/30/15.
 */
public class LongestIncreasingContinuousSubsequenceII {
    public static void main(String[] args) {
        int[][] board1 = {{99, 88, 77, 66, 55}, {44, 4, 5, 33, 22}, {999, 5, 6, 7, 888}, {777, 6, 7, 8, 666}, {555, 444, 8, 9, 10}};
        int[][] board2 = {{4, 3, 9}, {6, 5, 1}, {7, 8, 2}};
        int[][] board3 = {{4, 3, 9}, {6, 5, 8}, {7, 6, 7}};
        int[][] board4 = {{1, 5, 3}, {4, 10, 9}, {2, 8, 7}};
        int[][] board5 = {{1, 2, 3, 4, 5}, {16, 17, 24, 23, 6}, {15, 18, 25, 22, 7}, {14, 19, 20, 21, 8}, {13, 12, 11, 10, 9}};
        System.out.println(longestIncreasingContinuousSubsequenceII_backtrackingAndMemorization(board1)); // [4, 5, 6, 7, 8, 9, 10]
        System.out.println(longestIncreasingContinuousSubsequenceII_backtrackingAndMemorization(board2)); // [5, 6, 7, 8]
        System.out.println(longestIncreasingContinuousSubsequenceII_backtrackingAndMemorization(board3)); // [5, 6, 7, 8, 9]
        System.out.println(longestIncreasingContinuousSubsequenceII_backtrackingAndMemorization(board4));
        System.out.println(longestIncreasingContinuousSubsequenceII_backtrackingAndMemorization(board5));
    }


    public static int max;

    /*
    * backtracking;
    * */
    public static int longestIncreasingContinuousSubsequenceII_backtracking(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        max = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, visited, board[i][j] - 1, 1, i, j);
            }
        }
        return max;
    }

    private static void backtracking(int[][] board, boolean[][] visited, int previousNum, int count, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        if (board[i][j] > previousNum) {
            visited[i][j] = true;
            if (count >= max) {
                max = count;
            }

            backtracking(board, visited, board[i][j], count + 1, i - 1, j);
            backtracking(board, visited, board[i][j], count + 1, i + 1, j);
            backtracking(board, visited, board[i][j], count + 1, i, j - 1);
            backtracking(board, visited, board[i][j], count + 1, i, j + 1);

            visited[i][j] = false;
        }
    }


    /*
    * backtracking + Memorization;
    * */
    public static int longestIncreasingContinuousSubsequenceII_backtrackingAndMemorization(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        max = 0;
        int[][] memory = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (memory[i][j] == 0) {
                    backtrackingAndMemorization(board, memory, i, j);
                }
            }
        }
        return max;
    }

    private static int backtrackingAndMemorization(int[][] board, int[][] memory, int i, int j) {
        if (memory[i][j] > 0) {
            return memory[i][j];
        }

        int[] d = new int[4];

        if (i - 1 > 0 && board[i - 1][j] > board[i][j]) {
            d[0] = backtrackingAndMemorization(board, memory, i - 1, j);
        }
        if (i + 1 < board.length && board[i + 1][j] > board[i][j]) {
            d[1] = backtrackingAndMemorization(board, memory, i + 1, j);
        }
        if (j - 1 > 0 && board[i][j - 1] > board[i][j]) {
            d[2] = backtrackingAndMemorization(board, memory, i, j - 1);
        }
        if (j + 1 < board.length && board[i][j + 1] > board[i][j]) {
            d[3] = backtrackingAndMemorization(board, memory, i, j + 1);
        }

        memory[i][j] = Math.max(Math.max(d[0], d[1]), Math.max(d[2], d[3])) + 1;
        if (memory[i][j] > max) {
            max = memory[i][j];
        }
        return memory[i][j];
    }

    public int longestIncreasingContinuousSubsequenceII2(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int n = A.length;
        int m = A[0].length;
        int[][] L = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (L[i][j] == 0)
                    dfs(A, L, i, j, n, m);
            }
        }
        return this.max;
    }

    private int dfs(int[][] A, int[][] L, int i, int j, int n, int m) {
        if (L[i][j] > 0) {
            return L[i][j];
        }

        int x = A[i][j];
        int[] d = new int[4];
        if (j - 1 >= 0 && A[i][j - 1] > x)
            d[0] = dfs(A, L, i, j - 1, n, m);
        if (j + 1 < m && A[i][j + 1] > x)
            d[1] = dfs(A, L, i, j + 1, n, m);
        if (i - 1 >= 0 && A[i - 1][j] > x)
            d[2] = dfs(A, L, i - 1, j, n, m);
        if (i + 1 < n && A[i + 1][j] > x)
            d[3] = dfs(A, L, i + 1, j, n, m);

        L[i][j] = 1 + Math.max(Math.max(d[0], d[1]), Math.max(d[2], d[3]));
        if (L[i][j] > this.max)
            this.max = L[i][j];
        return L[i][j];
    }


//    public static List<Integer> res;
//
//    public static List<Integer> longestIncreasingContinuousSubsequenceII(int[][] board) {
//        if (board.length == 0 || board[0].length == 0) {
//            return new ArrayList<>();
//        } else {
//            res = new ArrayList<>();
//            boolean[][] visited = new boolean[board.length][board[0].length];
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    dfs(board, new ArrayList<Integer>(), visited, board[i][j] - 1, i, j);
//                }
//            }
//            return res;
//        }
//    }
//
//    private static void dfs(int[][] board, List<Integer> tmp, boolean[][] visited, int previousNum, int i, int j) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
//            return;
//        }
//
//        if (board[i][j] > previousNum) {
//            tmp.add(board[i][j]);
//            visited[i][j] = true;
//            if (tmp.size() > res.size()) {
//                res = new ArrayList<>(tmp);
//            }
//
//            dfs(board, tmp, visited, board[i][j], i - 1, j);
//            dfs(board, tmp, visited, board[i][j], i + 1, j);
//            dfs(board, tmp, visited, board[i][j], i, j - 1);
//            dfs(board, tmp, visited, board[i][j], i, j + 1);
//
//            tmp.remove(tmp.size() - 1);
//            visited[i][j] = false;
//        }

}
