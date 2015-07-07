package Leetcode.Easy;

/*
Count the number of prime numbers less than a non-negative number, n
*/
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(2)); // 0
        System.out.println(countPrimes(8)); // 4
        System.out.println(countPrimes(10)); // 4
        System.out.println(countPrimes(11)); // 4
        System.out.println(countPrimes(10000)); // 1229
    }

    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        } else {
            int count = 0;
            // range between [2,n-1]
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
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
