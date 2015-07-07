package Sorting.HeapSort.HeapSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class ArrayMaxHeapSortNatureOrder {
    public static void main(String[] args) {
        int[] a = {7, 14, 10, 12, 2, 11, 29, 3, 4};
        heapsort(a);
        System.out.println(Arrays.toString(a)); // [2, 3, 4, 7, 10, 11, 12, 14, 29]

        int[] b = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapsort(b);
        System.out.println(Arrays.toString(b)); // [1, 2, 3, 4, 7, 8, 9, 10, 14, 16]

        int[] c = {21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38};
        heapsort(c);
        System.out.println(Arrays.toString(c)); // [10, 21, 22, 30, 38, 40, 45, 66, 70, 81, 88, 95]
    }

    public static void heapsort(int[] a) {
        buildMaxHeap(a); // [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
        maintainMaxHeap(a);
    }

    public static void buildMaxHeap(int[] a) {
        int i = (a.length - 1) >> 1;
        while (i >= 0) {
            maintainMaxHeap(a, a.length, i);
            i--;
        }
    }

    public static void maintainMaxHeap(int[] a) {
        // 将最大值swap到后面
        // [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
        // [14, 8, 10, 4, 7, 9, 3, 2, 1, 16]
        // [10, 8, 9, 4, 7, 1, 3, 2, 14, 16]
        // [9, 8, 3, 4, 7, 1, 2, 10, 14, 16]
        // [8, 7, 3, 4, 2, 1, 9, 10, 14, 16]
        // [7, 4, 3, 1, 2, 8, 9, 10, 14, 16]
        // [4, 2, 3, 1, 7, 8, 9, 10, 14, 16]
        // [3, 2, 1, 4, 7, 8, 9, 10, 14, 16]
        // [2, 1, 3, 4, 7, 8, 9, 10, 14, 16]
        // [1, 2, 3, 4, 7, 8, 9, 10, 14, 16]
        int i = a.length - 1;
        while (i >= 1) {
            swap(a, i, 0);
            maintainMaxHeap(a, i, 0);
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
        // a[parentMax] - a[l] < 0 then then a[l] comes "before" a[parentMax] in the ordering,
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
