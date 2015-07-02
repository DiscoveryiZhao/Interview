package Matrix;

/**
 * Created by yizhao on 7/1/15.
 */
public class RotateImage {
    // from [1, 2, 3, 4] to [10, 11, 12, 1]
// from [12, 13, 14, 5] to [9, 16, 13, 2]
// from [11, 16, 15, 6] to [8, 15, 14, 3]
// from [10, 9, 8, 7] to [7, 6, 5, 4]
    public static void rotateClockwise90(int[][] matrix) {
        int n = matrix.length ;
        for (int left = 0, right = n - 1; left <= right; left++, right--) {
            for (int top = left, bottom = right; top < right; top++, bottom--) {
                int tmp = matrix[left][top];
                matrix[left][top] = matrix[bottom][left];
                matrix[bottom][left] = matrix[right][bottom];
                matrix[right][bottom] = matrix[top][right];
                matrix[top][right] = tmp;
            }
        }
    }

    // from [1, 2, 3, 4] to [4, 5, 6, 7]
// from [12, 13, 14, 5] to [3, 14, 15, 8]
// from [11, 16, 15, 6] to [2, 13, 16, 9]
// from [10, 9, 8, 7] to [1, 12, 11, 10]
    public static void rotateCounterClockwise90(int[][] matrix) {
        int n = matrix.length ;
        for (int left = 0, right = n - 1; left <= right; left++, right--) {
            for (int top = left, bottom = right; top < right; top++, bottom--) {
                int tmp = matrix[left][top];
                matrix[left][top] = matrix[top][right];
                matrix[top][right] = matrix[right][bottom];
                matrix[right][bottom] = matrix[bottom][left];
                matrix[bottom][left] = tmp;
            }
        }
    }
}
