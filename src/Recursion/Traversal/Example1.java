package Recursion.Traversal;

/**
 * Created by YZ on 8/29/15.
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println(traversal(4)); // 输出：8
    }

    public static int traversal(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return traversal(n - 1) * traversal(n - 2);
        }
    }
}
