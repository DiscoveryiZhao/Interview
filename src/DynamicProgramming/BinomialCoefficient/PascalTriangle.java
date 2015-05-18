package DynamicProgramming.BinomialCoefficient;

import java.util.ArrayList;

/**
 * Created by yizhao on 5/18/15.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result1 = generate(5);
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
        System. out.println(result1);
    }

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<ArrayList<Integer>>();
        } else {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            int[] dp = new int[numRows + 1];
            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> row = new ArrayList<Integer>();
                for (int j = i; j >= 0; j--) { // since triangle so we do reverse
                    if (j == 0 || j == i) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j - 1] + dp[j];
                    }
                    row.add(dp[j]);
                }
                res.add(row);
            }
            return res;
        }
    }
}
