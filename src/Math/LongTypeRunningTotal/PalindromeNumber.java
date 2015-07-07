package Math.LongTypeRunningTotal;

/**
 * Created by yizhao on 6/30/15.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321)); //true
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            long runningTotal = 0;
            long old = x;
            while (old != 0) {
                runningTotal = runningTotal * 10 + old % 10;
                old /= 10;
            }
            return runningTotal == x;
        }
    }
}
