package DynamicProgramming.SequenceDP.Others;

/**
 * Created by yizhao on 5/18/15.
 */
public class CoinsChange {
    public static void main(String[] args) {
        int[] coins = { 1, 3, 5 };
        System. out.println(coinsChange(coins, 0)); // 0
        System. out.println(coinsChange(coins, 1)); // 1
        System. out.println(coinsChange(coins, 2)); // 2
        System. out.println(coinsChange(coins, 3)); // 1
        System. out.println(coinsChange(coins, 4)); // 2
        System. out.println(coinsChange(coins, 5)); // 1
        System. out.println(coinsChange(coins, 6)); // 2
        System. out.println(coinsChange(coins, 7)); // 3
        System. out.println(coinsChange(coins, 8)); // 2
        System. out.println(coinsChange(coins, 9)); // 3
        System. out.println(coinsChange(coins, 10)); // 2
        System. out.println(coinsChange(coins, 11)); // 3
    }

    public static int coinsChange(int[] coins, int sum) {
        // state:
        int[] f = new int[sum + 1];
        // intialize for worst case: worst case for result of sum[0..i-1] is changed infinity coins,
        for(int i = 1; i < f.length; i++){
            f[i] = Integer. MAX_VALUE;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { // 硬币面值必须小于等于纸币面值，才可以换。
                    f[i] = Math. min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        return f[sum];
    }
}
