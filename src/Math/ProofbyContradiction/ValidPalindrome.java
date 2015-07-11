package Math.ProofbyContradiction;

/**
 * Created by yizhao on 6/30/15.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int L = 0;
        int R = n - 1;
        while (L < R) {
            if (!isLetter(s.charAt(L))) {
                L++;
                continue;
            }

            if (!isLetter(s.charAt(R))) {
                R--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
