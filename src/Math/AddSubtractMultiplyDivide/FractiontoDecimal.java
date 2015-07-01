package Math.AddSubtractMultiplyDivide;

/**
 * Created by yizhao on 6/30/15.
 */
public class FractiontoDecimal {
    public static void main(String[] args) {
        System. out.println(fractionToDecimal(2, 4)); // 0.5
        System. out.println(fractionToDecimal(1, 3)); // 0.(3)
        System. out.println(fractionToDecimal(1, 7)); // 0.(142857)
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        String res = "";
        while (numerator != 0) {
            res = res + Integer. toString(((numerator * 10) / denominator));
            numerator = (numerator * 10) % denominator;
            // 寻找无限不循环小数
            if (res.length() > 20) {
                return "0." + "(" + longestSubstringWithoutRepeatingCharacters(res) + ")";
            }
        }
        return "0." + res;
    }

    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        int n = s.length();
        boolean[] hash = new boolean[256];
        String res = "";
        int L = 0;
        int R = 0;
        while (R < n) {
            // a[L..R-1] satisfy !hash[s.charAt(right)]
            while (R < n && !hash[s.charAt(R)]) hash[s.charAt(R++)] = true;
            if(res.length() == 0 ||R - L > res.length() ){
                res = s.substring(L, R);
            }
            // find K
            while (R < n && s.charAt(L) != s.charAt(R)) hash[s.charAt(L++)] = false;
            L++; R++;
        }
        return res;
    }
}
