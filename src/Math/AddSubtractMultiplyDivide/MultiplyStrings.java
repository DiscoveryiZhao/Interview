package Math.AddSubtractMultiplyDivide;

/**
 * Created by yizhao on 6/30/15.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (m == 0 || n == 0) {
            return "" ;
        } else {
            if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
                return "0" ;
            } else {
                StringBuilder res = new StringBuilder();
                int carry = 0;
                for (int i = m + n - 2; i >= 0; i--) {
                    int bitSum = carry;
                    for (int j = i; j >= 0; j--) {
                        if (i - j < m && j < n) {
                            bitSum += (num1.charAt(i - j) - '0') * (num2.charAt(j) - '0');
                        }
                    }
                    carry = bitSum / 10;
                    res.append(bitSum % 10);
                }

                if (carry != 0) {
                    res.append(carry);
                }
                return res.reverse().toString();
            }
        }
    }
}
