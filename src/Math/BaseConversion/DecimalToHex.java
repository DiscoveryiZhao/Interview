package Math.BaseConversion;

/**
 * Created by yizhao on 6/30/15.
 */
public class DecimalToHex {
    public static void main(String[] args) {
        System.out.println(decimalToHex(2503, 16)); // 9C7
    }

    public static String decimalToHex(int num, int base) {
        String dict = "0123456789ABCDEF";
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(dict.charAt(num % base));
            num /= base;
        }
        return res.reverse().toString();
    }
}
