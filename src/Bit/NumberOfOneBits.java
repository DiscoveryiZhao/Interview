package Bit;

/**
 * Created by yizhao on 3/20/15.
 */
public class NumberOfOneBits {
    public static void main(String[] args) {
       System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
