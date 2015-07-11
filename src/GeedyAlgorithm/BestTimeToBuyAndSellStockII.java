package GeedyAlgorithm;

/**
 * Created by yizhao on 7/11/15.
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3 }; // 2
        int[] test2 = { 3, 2, 1 }; // 0
        int[] test3 = { 2, 2, 2 }; // 0
        int[] test4 = { 5, 1, 2 }; // 1
        System. out.println(maxProfit(test1)); // 2
        System. out.println(maxProfit(test2)); // 0
        System. out.println(maxProfit(test3)); // 0
        System. out.println(maxProfit(test4)); // 1
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length ;
        if (n == 0) {
            return 0;
        } else {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i - 1] < prices[i]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
    }
}
