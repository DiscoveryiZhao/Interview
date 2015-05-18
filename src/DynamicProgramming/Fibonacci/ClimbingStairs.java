package DynamicProgramming.Fibonacci;

/**
 * Created by yizhao on 5/18/15.
 */
public class ClimbingStairs {
    public static void main(String[] args){
        System. out.println(climbStairsRecursion(0)); // 0
        System. out.println(climbStairsRecursion(1)); // 1
        System. out.println(climbStairsRecursion(2)); // 2
        System. out.println(climbStairsRecursion(3)); // 3
        System. out.println(climbStairsRecursion(4)); // 5
        System. out.println(climbStairsRecursion(5)); // 8
    }

    public static int climbStairsRecursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);

    }
    public static int climbStairsDP1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] F = new int[n];
        F[0] = 1;
        F[1] = 2;
        for (int i = 2; i < n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n - 1];

    }
    public static int climbStairsDP2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int Fn = 2; // F(n)
        int F1 = 1; // F(n-1)
        int F2 = 2; // F(n-2)
        for (int i = 2; i < n; i++) {
            Fn = F1 + F2; // F(n) = F(n-1) + F(n-2)
            F1 = F2;
            F2 = Fn;
        }
        return Fn;
    }
}
