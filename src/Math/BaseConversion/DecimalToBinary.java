package Math.BaseConversion;

/**
 * Created by yizhao on 6/30/15.
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        System. out.println(decimalToBinary(2503, 2)); // 100111000111
    }

    public static String decimalToBinary(int num, int base) {
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(num % base);
            num /= base;
        }
        return res.reverse().toString();
    }
}
