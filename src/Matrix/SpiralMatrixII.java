package Matrix;

/**
 * Created by yizhao on 7/1/15.
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];

        for (int left = 0, right = n - 1, top = 0, bottom = n - 1; left <= right && top <= bottom; left++, right--, top++, bottom--) {
            // left to right
            for (int i = left; i <= right; i++) matrix[left][i] = num++;
            // top to bottom
            for (int i = top + 1; i <= bottom; i++) matrix[i][right] = num++;
            // right to left
            for (int i = right - 1; i >= left; i--) matrix[bottom][i] = num++;
            // bottom to top
            for (int i = bottom - 1; i >= top + 1; i--) matrix[i][top] = num++;
        }
        return matrix;
    }
}
