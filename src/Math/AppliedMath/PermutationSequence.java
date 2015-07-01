package Math.AppliedMath;

import java.util.ArrayList;

/**
 * Created by yizhao on 6/30/15.
 */
public class PermutationSequence {
    public static void main(String[] args) {

        System. out.println(getPermutation(3, 1)); // 123

        System. out.println(getPermutation(3, 2)); // 132

        System. out.println(getPermutation(3, 3)); // 213

        System. out.println(getPermutation(3, 4)); // 231

        System. out.println(getPermutation(2, 2)); // 21

    }

    public static String getPermutation(int n, int k) {

        StringBuilder res = new StringBuilder();

        ArrayList<Integer> k1_nums = new ArrayList<Integer>();

        int factorial = 1;

        for (int i = 1; i <= n; i++) {

            factorial *= i;

            k1_nums.add(i);

        }

        k--;

        for (int i = n; i > 0; i--) {

            factorial /= i; // (n - 1)! same as n! /= n

            int index = k / factorial;

            res.append(k1_nums.get(index));

            k1_nums.remove(index);

            k %= factorial;

        }

        return res.toString();

    }
}
