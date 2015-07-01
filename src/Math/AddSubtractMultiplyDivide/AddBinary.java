package Math.AddSubtractMultiplyDivide;

/**
 * Created by yizhao on 6/30/15.
 */
public class AddBinary {
    public static void main(String[] args) {
        System. out.println(addBinary( "11", "1" )); // 100
    }

    public static String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m == 0) {
            return b;
        } else if (n == 0) {
            return a;
        } else {
            StringBuilder res = new StringBuilder();
            int carry = 0;
            int i = m - 1;
            int j = n - 1;
            while (i >= 0 || j >= 0) {
                int bitSum = ((i >= 0) ? a.charAt(i) - '0' : 0) + ((j >= 0) ? b.charAt(j) - '0' : 0) + carry;
                carry = bitSum / 2; // if decimal addition, we change to bitSum/10
                res.append(bitSum %= 2); // if decimal addition, we change to bitSum %= 10
                i--;
                j--;
            }

            if (carry != 0) {
                res.append(carry);
            }
            return res.reverse().toString();
        }
    }
}
