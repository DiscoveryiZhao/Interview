package Sorting.HeapSort.HeapSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class BuildMaxHeap {
    public static void main(String[] args) {
        int[] a = {7, 14, 10, 12, 2, 11, 29, 3, 4};
        heapsort(a);
        System.out.println(Arrays.toString(a)); // [29, 14, 11, 12, 2, 7, 10, 3, 4]

        int[] b = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapsort(b);
        System.out.println(Arrays.toString(b)); // [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]

        int[] c = {21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38};
        heapsort(c);
        System.out.println(Arrays.toString(c)); // [95, 88, 81, 45, 70, 40, 30, 22, 10, 21, 66, 38]
    }

    public static void heapsort(int[] a) {
        buildMaxHeap(a);
    }

    public static void buildMaxHeap(int[] a) {
        int i = (a.length - 1) >> 1;
        while (i >= 0) {
            maintainMaxHeap(a, a.length, i);
            i--;
        }
    }

    public static void maintainMaxHeap(int[] a, int heapSize, int i) {
        int l = (i << 1) + 1; // left node index for array index start from 0
        int r = (i << 1) + 2; // right node index for array index start from 0
        int parentMax = i; // parent node index
        // a[parentMax] - a[l] < 0 then then a[l] comes "before" a[parentMax] in the ordering,
        if (l < heapSize && a[parentMax] - a[l] < 0) {
            parentMax = l; // a[l] is larger than a[parentMax]
        }
        // a[parentMax] - a[r] < 0 then then a[r] comes "before" a[parentMax] in the ordering,
        if (r < heapSize && a[parentMax] - a[r] < 0) {
            parentMax = r; // a[r] is larger than a[parentMax]
        }

        if (parentMax != i) {
            swap(a, parentMax, i);
            maintainMaxHeap(a, heapSize, parentMax);
        }
    }

    public static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
