package TwoPointers.ShuangJiBiZhongFa;

/**
 * Created by yizhao on 7/1/15.
 */
public class ReverseString {
    public static String reverse(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        char[] c = s.toCharArray();
        reverse(c, 0, n - 1);
        return new String(c);
    }

    public static void reverse(char[] a, int L, int R) {
        while (L < R) {
            swap(a, L++, R--);
        }
    }

    public static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
