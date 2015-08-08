package DynamicProgramming.Sequence;

/**
 * Created by yizhao on 5/18/15.
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int value[] = { 10, 40, 30, 50 };
        int weight[] = { 5, 4, 6, 3 };
        int nItems = 4;
        System. out.println(knapSack(nItems, 10, weight, value)); // 90
        System. out.println(knapSack(nItems, 9, weight, value)); // 90
        System. out.println(knapSack(nItems, 8, weight, value)); // 90
        System. out.println(knapSack(nItems, 7, weight, value)); // 90
        System. out.println(knapSack(nItems, 6, weight, value)); // 50
        System. out.println(knapSack(nItems, 5, weight, value)); // 50
        System. out.println(knapSack(nItems, 4, weight, value)); // 50
        System. out.println(knapSack(nItems, 3, weight, value)); // 50
        System. out.println(knapSack(nItems, 2, weight, value)); // 0
        System. out.println(knapSack(nItems, 1, weight, value)); // 0
        System. out.println(knapSack(nItems, 0, weight, value)); // 0
    }

    // Returns the maximum value that can be put in a knapsack of capacity
    public static int knapSack(int nItems, int capacity, int weight[], int value[]) {
        // state:
        int[][] dp = new int[nItems + 1][capacity + 1];
        // Build table dp [][] in bottom up manner
        for (int i = 1; i < nItems + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math. max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nItems][capacity];
    }
}
