package SelfTest;

/**
 * Created by yizhao on 5/2/15.
 */
public class Test1 {

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
