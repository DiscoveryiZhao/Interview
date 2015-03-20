package Bit;

/**
 * Created by yizhao on 3/20/15.
 */
public class Conclusion {
    public static void main(String[] args) {
        /**
         * Flip k-th digit
         * */
        System.out.println(FlipKthDigit(0, 1)); // 1
        System.out.println(FlipKthDigit(0, 2)); // 2
        System.out.println(FlipKthDigit(0, 3)); // 4
        System.out.println(FlipKthDigit(4, 3)); // 0
        System.out.println(FlipKthDigit(4, 4)); // 12
        /**
         * Flip last k digits
         * */
        System.out.println(FlipLastKDigit(0, 1)); // 1
        System.out.println(FlipLastKDigit(0, 2)); // 2
        System.out.println(FlipLastKDigit(0, 3)); // 4
        System.out.println(FlipLastKDigit(4, 3)); // 0
        System.out.println(FlipLastKDigit(4, 4)); // 12
        /**
         * Swap two numbers
         * */
        swapTwoNumbers(1,2); // a:2  ,b:1
        swapTwoNumbers2(1, 2); // a:2  ,b:1
     }

    /**
     * Flip k-th digit
     * */
    public static int FlipKthDigit(int n, int k) {
        // n与一左移快剑一
        return n ^ (1 << (k - 1));
    }

    /**
     * Flip last k digits
     * */
    public static int FlipLastKDigit(int n, int k) {
        return n ^ (1 << k - 1);
    }

    /**
     * Swap two numbers
     * */
    public static void swapTwoNumbers(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a:" + a + "  ,b:" + b);
    }

    public static void swapTwoNumbers2(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a + "  ,b:" + b);
    }
}
