package Sorting.BucketSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class SortWithAnotherArrayOrder {
    public static void main(String[] args) {
        int[] x = {17, 5, 1, 9};
        int[] a = {3, 2, 4, 1};
        System.out.println(Arrays.toString(sort(x, a))); // [9, 5, 17, 1]
        System.out.println(Arrays.toString(a)); // [1, 2, 3, 4]
    }

    public static int[] sort(int[] x, int[] a) {
        for (int i = 0; i < x.length; i++) {
            while (a[i] != i + 1) {
                // swap x
                int tmp = x[a[i] - 1];
                x[a[i] - 1] = x[i];
                x[i] = tmp;

                // swap a
                tmp = a[i];
                a[i] = a[tmp - 1];
                a[tmp - 1] = tmp;
            }
        }
        return x;
    }
}
