package Matrix;

import java.util.ArrayList;

/**
 * Created by yizhao on 7/1/15.
 */
public class SpiralMatrix {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        } else {
            int row = matrix.length , col = matrix[0].length;
            ArrayList<Integer> res = new ArrayList<Integer>();
            for (int left = 0, right = col - 1, top = 0, bottom = row - 1; left <= right && top <= bottom; left++, right--, top++, bottom--) {
                // left to right
                for (int i = left; i <= right; i++) res.add(matrix[left][i]);
                if (left == bottom) return res; // handles only one row cases
                // top to bottom
                for (int i = top + 1; i <= bottom; i++) res.add(matrix[i][right]);
                if (right == top) return res; // handles only one column cases
                // right to left
                for (int i = right - 1; i >= left; i--) res.add(matrix[bottom][i]);
                // bottom to top
                for (int i = bottom - 1; i >= top + 1; i--) res.add(matrix[i][top]);
            }
            return res;
        }
    }
}
