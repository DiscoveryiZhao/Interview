package DynamicProgramming.MatrixDP.MinimumPath;

import java.util.ArrayList;
import java.util.List;

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

        List<List<Integer>> testArrayList = new ArrayList<>();
        for (int i = 0; i < test1.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < test1[i].length; j++) {
                row.add(test1[i][j]);
            }
            testArrayList.add(row);
        }

        System.out.println(minimumTotal(testArrayList));
    }

    //Version 1: Bottom-Up
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();

        // state:
        int[][] f = new int[n][n];

        // intialize for worst case:
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle.get(n - 1).get(i);
        }

        // function:
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return f[0][0];
    }

//    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        int n = triangle.size();
//        if (n == 0) {
//            return 0;
//        } else {
//            int[] dp = new int[n];
//            for (int i = 0; i < n; i++) {
//                for (int j = i; j >= 0; j--) {// since triangle so we do reverse
//                    if (i == 0 && j == 0) {
//                        dp[0] = triangle.get(0).get(0);
//                    } else {
//                        if (i == j) dp[j] = triangle.get(i).get(j) + dp[j - 1];
//                        if (j == 0) dp[j] = triangle.get(i).get(j) + dp[j];
//                        if (i != j && j != 0) dp[j] = triangle.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
//                        //dp [j] = triangle.get(i).get(j) + Math.min((i != j ? dp[j] : Integer.MAX_VALUE), (j > 0 ? dp[j - 1] : Integer.MAX_VALUE));
//                    }
//                }
//            }
//            Arrays.sort(dp);
//            return dp[0];
//        }
//    }
}
