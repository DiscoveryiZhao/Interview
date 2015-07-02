package TwoPointers.ShuangJiBiZhongFa;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class RightRotatingAnArrayKTimesInPlace {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        rightRotateArray(a, 1);
        System. out.println(Arrays.toString(a)); // [5, 1, 2, 3, 4]

        int[] b = { 1, 2, 3, 4, 5 };
        rightRotateArray(b, 2);
        System. out.println(Arrays.toString(b)); // [4, 5, 1, 2, 3]

        int[] c = { 1, 2, 3, 4, 5 };
        rightRotateArray(c, 3);
        System. out.println(Arrays.toString(c)); // [3, 4, 5, 1, 2]

        int[] d = { 1, 2, 3, 4, 5 };
        rightRotateArray(d, 8);
        System. out.println(Arrays.toString(d)); // [3, 4, 5, 1, 2]
    }

    public static void rightRotateArray(int[] a, int k) {
        int n = a.length ;
        k = k % n; // handles k > n

        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
    }

    public static void reverse(int[] a, int left, int right) {
        while (left < right) {
            swap(a, left++, right--);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
