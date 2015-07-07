package Recursion;

/**
 * Created by yizhao on 1/3/15.
 */
public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(recur(0)); // 0
        System.out.println(recur(1)); // 1
        System.out.println(recur(2)); // 3
        System.out.println(recur(3)); // 6
        System.out.println(recur(4)); // 10
    }

    public static int recur(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return recur(n - 1) + n;
        }
    }
}
