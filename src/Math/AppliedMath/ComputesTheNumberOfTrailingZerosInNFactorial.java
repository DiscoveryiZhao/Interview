package Math.AppliedMath;

/**
 * Created by yizhao on 6/30/15.
 */
public class ComputesTheNumberOfTrailingZerosInNFactorial {
    public static void main(String[] args) {

        // 1! (or 1) has 0 zeros

        System. out.println(1 + "! (or " + factorial(1) + ") has " + countFactZeros(1) + " zeros");

        // 2! (or 2) has 0 zeros

        System. out.println(2 + "! (or " + factorial(2) + ") has " + countFactZeros(2) + " zeros");

        // 3! (or 6) has 0 zeros

        System. out.println(3 + "! (or " + factorial(3) + ") has " + countFactZeros(3) + " zeros");

        // 4! (or 24) has 0 zeros

        System. out.println(4 + "! (or " + factorial(4) + ") has " + countFactZeros(4) + " zeros");

        // 5! (or 120) has 1 zeros

        System. out.println(5 + "! (or " + factorial(5) + ") has " + countFactZeros(5) + " zeros");

        // 6! (or 720) has 1 zeros

        System. out.println(6 + "! (or " + factorial(6) + ") has " + countFactZeros(6) + " zeros");

        // 7! (or 5040) has 1 zeros

        System. out.println(7 + "! (or " + factorial(7) + ") has " + countFactZeros(7) + " zeros");

        // 8! (or 40320) has 1 zeros

        System. out.println(8 + "! (or " + factorial(8) + ") has " + countFactZeros(8) + " zeros");

        // 9! (or 362880) has 1 zeros

        System. out.println(9 + "! (or " + factorial(9) + ") has " + countFactZeros(9) + " zeros");

        // 10! (or 3628800) has 2 zeros

        System. out.println(10 + "! (or " + factorial(10) + ") has " + countFactZeros(10) + " zeros");

        // 11! (or 39916800) has 2 zeros

        System. out.println(11 + "! (or " + factorial(11) + ") has " + countFactZeros(11) + " zeros");

    }

    public static int countFactZeros(int num) {

        if (num < 0) {

            System. out.println("Factorial is not defined for negative numbers" );

            return 0;

        } else {

            int count = 0;

            while(num >= 5){

                count += num / 5;

                num/=5;

            }

            return count;

        }

    }


    public static int factorial(int n) {

        if (n == 0) {

            return 1;

        } else {

            int[] f = new int[n + 1];

            f[0] = 1;

            for (int i = 1; i < n + 1; i++) {

                f[i] = i;

                f[i] = f[i] * f[i - 1];

            }

            return f[n];

        }

    }
}
