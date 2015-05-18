package DynamicProgramming.MinimumPath;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yizhao on 5/18/15.
 */
public class Triangle {
    // [2],
    // [3,4],
    // [6,5,7],
    // [4,1,8,3]
    public static void main(String[] args) {
        // input: [[2],[3,4],[6,5,7]]
        int[][] test1 = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}; // 11
        int[][] test2 = {{-1}, {2, 3}, {1, -1, -3}}; // -1

        ArrayList<ArrayList<Integer>> testArrayList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < test1.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < test1[i].length; j++) {
                row.add(test1[i][j]);
            }
            testArrayList.add(row);
        }

        System.out.println(minimumTotal(testArrayList));
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        } else {
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {// since triangle so we do reverse
                    if (i == 0 && j == 0) {
                        dp[0] = triangle.get(0).get(0);
                    } else {
                        if (i == j) dp[j] = triangle.get(i).get(j) + dp[j - 1];
                        if (j == 0) dp[j] = triangle.get(i).get(j) + dp[j];
                        if (i != j && j != 0) dp[j] = triangle.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
                        //dp [j] = triangle.get(i).get(j) + Math.min((i != j ? dp[j] : Integer.MAX_VALUE), (j > 0 ? dp[j - 1] : Integer.MAX_VALUE));
                    }
                }
            }
            Arrays.sort(dp);
            return dp[0];
        }
    }
}
