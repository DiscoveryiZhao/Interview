package Sorting.HeapSort.HeapSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class ArrayHeapSortClosestToNumKOrder {
    public static void main(String[] args) {
        int[] a = {7, 14, 10, 12, 2, 11, 29, 3, 4};
        heapsort(a, 10);
        System.out.println(Arrays.toString(a)); // [10, 11, 12, 7, 14, 4, 3, 2, 29]

        int[] b = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapsort(b, 10);
        System.out.println(Arrays.toString(b)); // [10, 9, 8, 7, 14, 16, 4, 3, 2, 1]

        int[] c = {21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38};
        heapsort(c, 10);
        System.out.println(Arrays.toString(c)); // [10, 21, 22, 30, 38, 40, 45, 66, 70, 81, 88, 95]
    }

    public static void heapsort(int[] a, int k) {
        buildMaxHeap(a, k);
        maintainMaxHeap(a, k);
    }

    public static void buildMaxHeap(int[] a, int k) {
        int i = (a.length - 1) >> 1;
        while (i >= 0) {
            maintainMaxHeap(a, a.length, i, k);
            i--;
        }
    }

    public static void maintainMaxHeap(int[] a, int k) {
        int i = a.length - 1;
        while (i >= 1) {
            swap(a, i, 0);
            maintainMaxHeap(a, i, 0, k);
            i--;
        }
    }

    public static void maintainMaxHeap(int[] a, int heapSize, int i, int k) {
        int l = (i << 1) + 1; // left node index for array index start from 0
        int r = (i << 1) + 2; // right node index for array index start from 0
        int parentMax = i; // parent node index
        // a[parentMax] - a[l] < 0 then then a[l] comes "before" a[parentMax] in the ordering,
        if (l < heapSize && Math.abs(a[parentMax] - k) - Math.abs(a[l] - k) < 0) {
            parentMax = l; // a[l] is close to k than a[parentMax]
        }
        // a[parentMax] - a[l] < 0 then then a[l] comes "before" a[parentMax] in the ordering,
        if (r < heapSize && Math.abs(a[parentMax] - k) - Math.abs(a[r] - k) < 0) {
            parentMax = r; // a[r] is close to k than a[parentMax]
        }

        if (parentMax != i) {
            swap(a, parentMax, i);
            maintainMaxHeap(a, heapSize, parentMax, k);
        }
    }

    public static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
