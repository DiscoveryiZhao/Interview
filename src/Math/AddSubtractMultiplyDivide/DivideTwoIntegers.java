package Math.AddSubtractMultiplyDivide;

/**
 * Created by yizhao on 6/30/15.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(100, 2)); // 50
        // System.out.println(divide(100, 5)); // 20
    }

    public static int divide(int numerator, int denominator) {
        long res = 0;
        // ^ is xor operator
        // Odd count of one at most signfic bit position, then sign is negative
        int sign = (((numerator ^ denominator) < 0)) ? -1 : 1;
        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);
        while (a >= b) {
            int power = 1;
            while (a >= (b << power)) {
                power++;
            }
            res += 1 << (power - 1);
            a -= b << (power - 1);
        }
        return (int) (sign * res);
    }
}
