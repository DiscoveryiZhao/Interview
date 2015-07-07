package Sorting.HeapSort.HeapSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class BuildMinHeap {
    public static void main(String[] args) {
        int[] a = { 7, 14, 10, 12, 2, 11, 29, 3, 4 };
        heapsort(a);
        System. out.println(Arrays.toString(a)); // [2, 3, 10, 4, 14, 11, 29, 12, 7]

        int[] b = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        heapsort(b);
        System. out.println(Arrays.toString(b)); // [1, 2, 3, 4, 7, 9, 10, 14, 8, 16]

        int[] c = { 21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38 };
        heapsort(c);
        System. out.println(Arrays.toString(c)); // [10, 21, 30, 22, 70, 38, 40, 66, 45, 95, 88, 81]
    }

    public static void heapsort(int[] a) {
        buildMinHeap(a);
    }

    public static void buildMinHeap(int[] a) {
        int i = (a.length - 1) >> 1;
        while (i >= 0) {
            maintainMinHeap(a, a.length, i);
            i--;
        }
    }

    public static void maintainMinHeap(int[] a, int heapSize, int i) {
        int l = (i << 1) + 1; // left node index for array index start from 0
        int r = (i << 1) + 2; // right node index for array index start from 0
        int parentMax = i; // parent node index
        // a[parentMax] - a[l] > 0 then then a[l] comes "before" a[parentMax] in the ordering,
        if (l < heapSize && a[parentMax] - a[l] > 0) {
            parentMax = l; // a[l] is larger than a[parentMax]
        }
        // a[parentMax] - a[r] > 0 then then a[r] comes "before" a[parentMax] in the ordering,
        if (r < heapSize && a[parentMax] - a[r] > 0) {
            parentMax = r; // a[r] is larger than a[parentMax]
        }

        if (parentMax != i) {
            swap(a, parentMax, i);
            maintainMinHeap(a, heapSize, parentMax);
        }
    }

    public static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
