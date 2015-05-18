package DynamicProgramming.Sequence;

/**
 * Created by yizhao on 5/18/15.
 */
public class RodCutting {
    public static void main(String args[]) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
        System. out.println(rodCutting(price, 1)); // 1
        System. out.println(rodCutting(price, 2)); // 5
        System. out.println(rodCutting(price, 3)); // 8
        System. out.println(rodCutting(price, 4)); // 10
        System. out.println(rodCutting(price, 5)); // 13
        System. out.println(rodCutting(price, 6)); // 17
        System. out.println(rodCutting(price, 7)); // 18
    }

    public static int rodCutting(int[] price, int RodLength) {
        int dp[] = new int[RodLength + 1];
        for (int i = 1; i <= RodLength; i++) {
            for (int j = 0; j < price.length; j++) {
                if (j < i) {
                    dp[i] = Math. max(dp[i], dp[j] + price[i - 1 - j]);
                }
            }
        }
        return dp[RodLength];
    }
}
