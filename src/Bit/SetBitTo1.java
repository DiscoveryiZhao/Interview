package Bit;

/**
 * Created by yizhao on 3/25/15.
 */
public class SetBitTo1 {
    public static void main(String[] args) {
        System.out.println(setBitTo1(16, 0)); // 1
        System.out.println(setBitTo1(16, 1)); // 2
        System.out.println(setBitTo1(16, 2)); // 4
        System.out.println(setBitTo1(16, 3)); // 8
        System.out.println(setBitTo1(16, 4)); // 16
    }

    public static int setBitTo1(int n, int k) {
        return n |= (1 << k);
    }
}
