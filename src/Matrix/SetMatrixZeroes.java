package Matrix;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        // 输入:
        // [1, 1, 1, 1]
        // [1, 1, 0, 1]
        // [1, 1, 1, 1]
        // [1, 1, 1, 1]
        setZeroes(matrix);
        // 输出:
        // [1, 1, 0, 1]
        // [0, 0, 0, 0]
        // [1, 1, 0, 1]
        // [1, 1, 0, 1]
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println();
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        if (matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;

        boolean hasZeroFirstRow = false, hasZeroFirstColumn = false;

        // Does first row have zero?
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                hasZeroFirstRow = true;
                break;
            }
        }

        // Does first column have zero?
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                hasZeroFirstColumn = true;
                break;
            }
        }

        // find zeroes and store the info in first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes except the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set zeroes for first row and column if needed
        if (hasZeroFirstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (hasZeroFirstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
