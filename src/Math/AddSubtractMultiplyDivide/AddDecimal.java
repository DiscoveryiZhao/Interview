package Math.AddSubtractMultiplyDivide;

/**
 * Created by yizhao on 6/30/15.
 */
public class AddDecimal {
    public static void main(String[] args) {
        System.out.println(addDecimal("11", "1")); // 12
    }

    public static String addDecimal(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m == 0) {
            return b;
        }
        if (n == 0) {
            return a;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            int bitSum = ((i >= 0) ? a.charAt(i) - '0' : 0) + ((j >= 0) ? b.charAt(j) - '0' : 0) + carry;
            carry = bitSum / 10; // if binary addition, we change to bitSum/2
            res.append(bitSum %= 10); // if binary addition, we change to bitSum %= 2
            i--;
            j--;
        }

        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
