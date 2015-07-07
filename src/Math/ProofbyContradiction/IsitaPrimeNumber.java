package Math.ProofbyContradiction;

/**
 * Created by yizhao on 6/30/15.
 */
public class IsitaPrimeNumber {
    public static void main(String[] args) {
        int[] a1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59}; // all true
        int[] a2 = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28};  // all false
        for (int i : a1) {
            System.out.println(isPrime(i));
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false; // prime must >=2
        if (n == 2) return true;
        if ((n & 1) == 0) return false; // there are no even primes greater than 2

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) { // 没有余数，就说明可以被整除，故false
                return false;
            }
        }
        return true;
    }

}
