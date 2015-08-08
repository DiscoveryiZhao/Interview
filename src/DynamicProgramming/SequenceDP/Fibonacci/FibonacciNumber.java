package DynamicProgramming.SequenceDP.Fibonacci;

/**
 * Created by yizhao on 5/18/15.
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacciNumberRecursion(0)); // 0
        System.out.println(fibonacciNumberRecursion(1)); // 1
        System.out.println(fibonacciNumberRecursion(2)); // 1
        System.out.println(fibonacciNumberRecursion(3)); // 2
        System.out.println(fibonacciNumberRecursion(4)); // 3
        System.out.println(fibonacciNumberRecursion(5)); // 5
    }

    public static int fibonacciNumberRecursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciNumberRecursion(n - 1) + fibonacciNumberRecursion(n - 2);
    }

    public static int fibonacciNumberDP1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

    public static int fibonacciNumberDP2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int Fn = 1; // F(n)
        int F1 = 1; // F(n-1)
        int F2 = 1; // F(n-2)
        for (int i = 2; i < n; i++) {
            Fn = F1 + F2; // F(n) = F(n-1) + F(n-2)
            F1 = F2;
            F2 = Fn;
        }
        return Fn;
    }
}
