package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 7/1/15.
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        for (int L = 0, R = col - 1, T = 0, B = row - 1; L <= R && T <= B; L++, R--, T++, B--) {
            // left to right
            for (int i = L; i <= R; i++) res.add(matrix[L][i]);
            if (L == B) return res; // handles only one row cases
            // top to bottom
            for (int i = T + 1; i <= B; i++) res.add(matrix[i][R]);
            if (R == T) return res; // handles only one column cases
            // right to left
            for (int i = R - 1; i >= L; i--) res.add(matrix[B][i]);
            // bottom to top
            for (int i = B - 1; i >= T + 1; i--) res.add(matrix[i][T]);
        }
        return res;
    }
}
