package Math.AppliedMath;

/**
 * Created by yizhao on 6/30/15.
 */
public class ZigZagConversion {
    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR

    }

    public static String convert(String s, int nRows) {

        int n = s.length();

        if (n == 0 || nRows < 2) {

            return s;

        } else {

            StringBuilder res = new StringBuilder();

            for (int i = 0; i < nRows; i++) {

                int oddColPos = i;

                while (oddColPos < n) {

                    res.append(s.charAt(oddColPos));

                    oddColPos += 2 * nRows - 2;

                    int evenColPos = oddColPos - 2 * i;

                    // true if is even row

                    if (i > 0 && i < nRows - 1 && (evenColPos) < n) {

                        res.append(s.charAt(evenColPos));

                    }

                }

            }

            return res.toString();

        }

    }
}
