package SelfTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yizhao on 5/2/15.
 */
public class Test1 {
    // [2],
// [3,4],
// [6,5,7],
// [4,1,8,3]
    public static void main(String[] args) {
        // input: [[2],[3,4],[6,5,7]]
        int[][] test1 = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } }; // 11
        int[][] test2 = { { -1 }, { 2, 3 }, { 1, -1, -3 } }; // -1

        ArrayList<ArrayList<Integer>> testArrayList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < test1.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < test1[i].length; j++) {
                row.add(test1[i][j]);
            }
            testArrayList.add(row);
        }

        System. out.println(minimumTotal(testArrayList));
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for(int i=0; i < n; i++){
            System.out.println(Arrays.toString(sum[i]));
        }

        System.out.println();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
            }
            for(int k=0; k < n; k++){
                System.out.println(Arrays.toString(sum[k]));
            }
            System.out.println();
        }

        return sum[0][0];
    }
}
