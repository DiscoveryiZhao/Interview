package Bit;

/**
 * Created by yizhao on 3/20/15.
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));// 964176192
        System.out.println(reverseBits(1));
        System.out.println(reverseBits(2^32 - 1));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        for (int k = 1; k < 32; k++) {
            n ^= (1 << (k - 1));
        }
        return n;
    }
}