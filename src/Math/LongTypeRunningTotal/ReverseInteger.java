package Math.LongTypeRunningTotal;

/**
 * Created by yizhao on 6/30/15.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int test1 = -321;
        System.out.println(reverse(test1)); // -123
    }

    public static int reverse(int x) {
        long runningTotal = 0;
        while (x != 0) {
            runningTotal = (runningTotal * 10) + x % 10;
            x /= 10;
        }
        return (int) runningTotal;
    }
}
