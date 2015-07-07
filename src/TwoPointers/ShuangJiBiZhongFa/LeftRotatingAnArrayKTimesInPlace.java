package TwoPointers.ShuangJiBiZhongFa;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class LeftRotatingAnArrayKTimesInPlace {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        leftRotateArray(a, 1);
        System.out.println(Arrays.toString(a)); // [2, 3, 4, 5, 1]

        int[] b = {1, 2, 3, 4, 5};
        leftRotateArray(b, 2);
        System.out.println(Arrays.toString(b)); // [3, 4, 5, 1, 2]

        int[] c = {1, 2, 3, 4, 5};
        leftRotateArray(c, 3);
        System.out.println(Arrays.toString(c)); // [4, 5, 1, 2, 3]

        int[] d = {1, 2, 3, 4, 5};
        leftRotateArray(d, 8);
        System.out.println(Arrays.toString(d)); // [4, 5, 1, 2, 3]
    }

    public static void leftRotateArray(int[] a, int k) {
        int n = a.length;
        k = k % n; // handles k > n
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        reverse(a, 0, n - 1);
    }

    public static void reverse(int[] a, int L, int R) {
        while (L < R) {
            swap(a, L++, R--);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
