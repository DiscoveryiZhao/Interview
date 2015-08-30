package DynamicProgramming.ForwardDpThenBackwardDp;

/**
 * Created by yizhao on 5/18/15.
 */
public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int[] test1 = {5, 1, 2, 3, 5, 2, 6, 8, 9, 6, 0}; // 11
        int[] test2 = {3, 2, 1}; // 0
        int[] test3 = {2, 2, 2}; // 0
        int[] test4 = {5, 1, 2}; // 1
        System.out.println(maxProfit(test1)); // 11
        System.out.println(maxProfit(test2)); // 0
        System.out.println(maxProfit(test3)); // 0
        System.out.println(maxProfit(test4)); // 1
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] dpF = new int[n];
        int[] dpB = new int[n];

        int localMaxProfit = 0;
        int localMinValue = prices[0];
        for (int i = 1; i < n; i++) {
            localMinValue = Math.min(localMinValue, prices[i]);
            localMaxProfit = prices[i] - localMinValue;
            dpF[i] = Math.max(dpF[i - 1], localMaxProfit);
        }

        localMaxProfit = 0;
        int localMaxValue = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            localMaxValue = Math.max(localMaxValue, prices[i]);
            localMaxProfit = localMaxValue - prices[i];
            dpB[i] = Math.max(dpB[i + 1], localMaxProfit);
        }

        int globalMaxProfit = 0;
        for (int i = 0; i < n; i++) {
            globalMaxProfit = Math.max(globalMaxProfit, dpF[i] + dpB[i]);
        }
        return globalMaxProfit;
    }
}
