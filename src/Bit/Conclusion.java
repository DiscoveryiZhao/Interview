package Bit;

/**
 * Created by yizhao on 3/20/15.
 */
public class Conclusion {
    public static void main(String[] args) {
        /**
         * Flip k-th digit
         * */
        System.out.println();
        System.out.println(">>>>>>>>>> Flip k-th digit <<<<<<<<<<");
        System.out.println(FlipKthDigit(0, 1)); // 0000 -> 0001 = 1
        System.out.println(FlipKthDigit(0, 2)); // 0000 -> 0010 = 2
        System.out.println(FlipKthDigit(0, 3)); // 0000 -> 0100 = 4
        System.out.println(FlipKthDigit(4, 3)); // 0100 -> 0000 = 0
        System.out.println(FlipKthDigit(4, 4)); // 0100 -> 1100 = 12

        /**
         * Swap two numbers
         * */
        System.out.println();
        System.out.println(">>>>>>>>>> Swap two numbers <<<<<<<<<<");
        swapTwoNumbers(1, 2); // a:2  ,b:1
        swapTwoNumbers2(1, 2); // a:2  ,b:1


        /**
         * Shift
         * */
        System.out.println();
        System.out.println(">>>>>>>>>> Shift <<<<<<<<<<");
        leftShift();
        rightShift();
    }

    /**
     * Flip k-th digit
     */
    public static int FlipKthDigit(int n, int k) {
        // n异或(一左移快剑一)
        return n ^ (1 << (k - 1));
    }

    /**
     * Swap two numbers
     */
    public static void swapTwoNumbers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a:" + a + "  ,b:" + b);
    }

    public static void swapTwoNumbers2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a + "  ,b:" + b);
    }

    /**
     * Left Shift
     */
    public static void leftShift() {
        System.out.println(1 << 1); // 2
        System.out.println(1 << 2); // 4
        System.out.println(1 << 3); // 8
        System.out.println(1 << 4); // 16
        System.out.println(1 << 5); // 32
    }

    /**
     * Right Shift
     */
    public static void rightShift() {
        System.out.println(32 >> 1); // 16
        System.out.println(32 >> 2); // 8
        System.out.println(32 >> 3); // 4
        System.out.println(32 >> 4); // 2
        System.out.println(32 >> 5); // 1
    }
}
