package Sorting.WaveSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
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
        for (int i = 1; i < n; i++) {
            if ((((i & 1) == 1) && !(a[i - 1] <= a[i])) || (((i & 1) == 0) && !(a[i - 1] >= a[i]))) {
                int tmp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = tmp;
            }
        }
    }

    public static void sortArrayWithoutSwap(int[] a) {
        int n = a.length;
        int tmp = a[0];
        for (int i = 1; i < n; i++) {
            if ((((i & 1) == 1) && !(a[i - 1] <= a[i])) || (((i & 1) == 0) && !(a[i - 1] >= a[i]))) {
                a[i - 1] = a[i];
            } else {
                a[i - 1] = tmp;
                tmp = a[i];
            }
        }
        a[n - 1] = tmp;
    }
}
