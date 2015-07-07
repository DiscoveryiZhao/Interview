package Sorting.HeapSort.HeapSort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yizhao on 7/7/15.
 */
public class PriorityQueueMinHeapSortNatureOrder {
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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : a) {
            minHeap.add(i);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = minHeap.poll();
        }
    }
}
