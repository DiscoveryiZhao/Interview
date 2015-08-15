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
        }

        long oldX = x;
        long runningTotal = 0;
        while (oldX != 0) {
            runningTotal = runningTotal * 10 + oldX % 10;
            oldX /= 10;
        }
        return runningTotal == x;
    }
}
