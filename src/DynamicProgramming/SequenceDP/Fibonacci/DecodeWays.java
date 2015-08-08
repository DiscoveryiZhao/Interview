package DynamicProgramming.SequenceDP.Fibonacci;

/**
 * Created by yizhao on 5/18/15.
 */
public class DecodeWays {
    public static void main(String[] args) {
        System. out.println(numDecodings( "01")); // 0
        System. out.println(numDecodings( "20")); // 1 -> F(n) = F(n-1)
        System. out.println(numDecodings( "26")); // 2 -> F(n) = F(n-1) + F(n-2)
    }

    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        } else {
            // This could be solved by DP.
            // Let F(n) denote the number of decode ways for a string of length n. The following is the recursive formula:
            // F(n) = F(n-1) if s[n-1] is a valid encoding digit and s[n-2]s[n-1] is NOT a valid encoding number.
            // F(n) = F(n-2) if s[n-1] is NOT a valid encoding digit and s[n-2]s[n-1] is a valid encoding number.
            // F(n) = F(n-1) + F(n-2) if s[n-1] is a valid encoding digit and s[n-2]s[n-1] is also a valid encoding number.
            // F(n) = 0 if s[n-1] is NOT a valid encoding digit and s[n-2]s[n-1] is NOT a valid encoding number.
            int[] f = new int[n + 1];
            f[0] = 1;
            if (s.charAt(0) != '0' ) {
                f[1] = 1;
            }

            for (int i = 2; i < n + 1; i++) {
                boolean one = s.charAt(i - 1) != '0' ;
                boolean two = s.charAt(i - 2) != '0' && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'));
                if (!one && !two) { // 00
                    f[i] = 0;
                } else if (!one && two) { // 01
                    f[i] = f[i - 2];
                } else if (one && !two) { // 10
                    f[i] = f[i - 1];
                } else if (one && two) { // 11
                    f[i] = f[i - 1] + f[i - 2];
                }
            }
            return f[n];
        }
    }
}
