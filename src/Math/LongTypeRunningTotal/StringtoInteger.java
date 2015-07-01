package Math.LongTypeRunningTotal;

/**
 * Created by yizhao on 6/30/15.
 */
public class StringtoInteger {
    public int atoi(String str) {
        str = str.trim();
        int n = str.length();
        if (n == 0) {
            return 0;
        } else {
            long runningTotal = 0;
            int sign = 1;
            int i = 0;
            if (str.charAt(i) == '-' ) {
                sign = -1;
                i++;
            } else if (str.charAt(i) == '+') {
                i++;
            }

            // convert digits
            while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                runningTotal = runningTotal * 10 + (str.charAt(i) - '0');
                i++;
                if (sign > 0 && runningTotal > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (sign < 0 && (-1) * runningTotal < Integer.MIN_VALUE) return Integer.MIN_VALUE ;
            }
            return (int ) runningTotal * sign;
        }
    }
}
