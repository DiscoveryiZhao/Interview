package Matrix;

/**
 * Created by yizhao on 7/1/15.
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];

        for (int L = 0, R = n - 1, T = 0, B = n - 1; L <= R && T <= B; L++, R--, T++, B--) {
            // left to right
            for (int i = L; i <= R; i++) matrix[L][i] = num++;
            // top to bottom
            for (int i = T + 1; i <= B; i++) matrix[i][R] = num++;
            // right to left
            for (int i = R - 1; i >= L; i--) matrix[B][i] = num++;
            // bottom to top
            for (int i = B - 1; i >= T + 1; i--) matrix[i][T] = num++;
        }
        return matrix;
    }
}
