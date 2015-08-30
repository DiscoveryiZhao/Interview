package DynamicProgramming.LocalOptimalSolutionThenGlobalOptimalSolution;

/**
 * Created by yizhao on 5/18/15.
 */
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3}; // 2
        int[] test2 = {3, 2, 1}; // 0
        int[] test3 = {2, 2, 2}; // 0
        int[] test4 = {5, 1, 2}; // 1
        System.out.println(maxProfit(test1)); // 2
        System.out.println(maxProfit(test2)); // 0
        System.out.println(maxProfit(test3)); // 0
        System.out.println(maxProfit(test4)); // 1
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;  //just remember the smallest price
        int profit = 0;
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;
    }

/*
    // Iterate through the array
    // computes the local minimum value dynamically
    // computes local max profit
    // computes global maximum profit dynamically by subtracting
    // current value with local minimum value
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int subMinVal = prices[0];
        int local = 0;
        int global = 0;
        for (int i = 1; i < n; i++) {
            subMinVal = Math.min(subMinVal, prices[i]);
            local = prices[i] - subMinVal;
            global = Math.max(global, local);
        }
        return global;
    }
*/
}
