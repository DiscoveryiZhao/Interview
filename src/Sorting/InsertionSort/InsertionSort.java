package Sorting.InsertionSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {2, 4, 8, 4, 5, 1, 3, 9};
        insertionSort(a);
        // [1, 2, 3, 4, 4, 5, 8, 9]
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            // slide elements i to make room for a[i]
            int j = i;
            while (j - 1 >= 0 && a[j - 1] > tmp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }
    }
}
