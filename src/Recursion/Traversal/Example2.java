package Recursion.Traversal;

/**
 * Created by YZ on 8/29/15.
 */
public class Example2 {

    public static void main(String[] args) {
        System.out.println(traversal(3)); // 输出：6
        System.out.println(traversal(4)); // 输出：24
    }

    /*
        4-> 6*4 = 24
        |
        3-> 2*3 = 6
        |
        2-> 1*2 = 2
        |
        1-> 1*1 = 1
        |
        0-> return 1
    */
    public static int traversal(int n) {
        if (n == 0) {
            return 1;
        } else {
            return traversal(n - 1) * n;
        }
    }
}
