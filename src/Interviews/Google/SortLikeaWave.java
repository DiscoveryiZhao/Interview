package Interviews.Google;

import java.util.Arrays;

/**
 * Given an array of integers, sort the array into a wave like array, namely a1 >= a2 <= a3 >= a4 <= a5.....
 */
public class SortLikeaWave {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 3, 2, 5};
        sortArrayWithSwap(a);
        // [1, 3, 2, 7, 2, 5, 3]
        System.out.println(Arrays.toString(a));

        int[] b = {3, 2, 1};
        sortArrayWithSwap(b);
        // [2,3,1]
        System.out.println(Arrays.toString(b));

        int[] c = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3};
        sortArrayWithSwap(c);
        // [1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 2, 3, 3, 3, 3]
        System.out.println(Arrays.toString(c));
    }

    public static void sortArrayWithSwap(int[] a) {
        int n = a.length;
        int right = 1;
        while (right < n) {
            if ((((right & 1) == 1) && !(a[right - 1] <= a[right])) || (((right & 1) == 0) && !(a[right - 1] >= a[right]))) {
                int tmp = a[right];
                a[right] = a[right - 1];
                a[right - 1] = tmp;
            }
            right++;
        }
    }

    public static void sortArrayWithoutSwap(int[] a) {
        int n = a.length;
        int tmp = a[0];
        int right = 1;
        while (right < n) {
            if ((((right & 1) == 1) && !(a[right - 1] <= a[right])) || (((right & 1) == 0) && !(a[right - 1] >= a[right]))) {
                a[right - 1] = a[right];
            } else {
                a[right - 1] = tmp;
                tmp = a[right];
            }
            right++;
        }
        a[n - 1] = tmp;
    }
}
