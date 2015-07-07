package Math.ProofbyContradiction;

import java.util.Arrays;

/**
 * Created by yizhao on 6/30/15.
 */
public class PrintPrimeNumbers {
    public static void main(String[] args) {
        // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
        printPrimes(59);
    }

    public static void printPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false; // 0 不是prime
        primes[1] = false; // 1不是prime
        for (int i = 2; i <= Math.sqrt(n); i++) { // [1]
            // true if i is prime number, since i 能被 n 整除
            if (primes[i]) {
                // 将prime number i的自身倍数全部都设为false， 因为他们不是prime number
                // prime number->2的倍数：4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,
                // prime number->3的倍数：9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,
                // prime number->5的倍数：25,30,35,40,45,50,55,
                // prime number->7的倍数：49,56,
                for (int j = i * i; j <= n; j += i) { // [2]
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + ", ");
            }
        }
    }
}
