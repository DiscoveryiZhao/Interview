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
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

//    public static int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;  //just remember the smallest price
//        int profit = 0;
//        for (int i : prices) {
//            min = Math.min(min, i);
//            profit = Math.max(profit, i - min);
//        }
//
//        return profit;
//    }
}
