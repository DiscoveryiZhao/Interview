package Math.AppliedMath;

/**
 * Created by yizhao on 6/30/15.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2, 1)); // 2.0
        System.out.println(pow(2, 2)); // 4.0
        System.out.println(pow(2, 3)); // 8.0
        System.out.println(pow(2, 4)); // 16.0
        System.out.println(pow(2, 5)); // 32.0
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int absN = Math.abs(n);
        double res = pow(x, absN / 2);
        res *= res;
        res *= (absN % 2) == 1 ? x : 1;
        return (n > 0) ? res : 1.0 / res;
    }
}
