package Math.Roman;

/**
 * Created by yizhao on 6/30/15.
 */
public class IntegertoRoman {
    public static String intToRoman(int num) {
        String res = "";
        int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num != 0) {
            // res:""
            // res:MMM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCM
            // res:MMMCMIV
            while (num >= integers[i]) {
                num -= integers[i];
                res += roman[i];
            }
            i++;
        }
        return res;
    }
}
