package Sorting.HeapSort.HeapSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yizhao on 7/7/15.
 */
public class PriorityQueueMinHeapSortClosestToNumKOrder {
    public static void main(String[] args) {
        int[] a = { 7, 14, 10, 12, 2, 11, 29, 3, 4 };
        heapsort(a, 10);
        System. out.println(Arrays.toString(a)); // [10, 11, 12, 7, 14, 4, 3, 2, 29]

        int[] b = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        heapsort(b, 10);
        System. out.println(Arrays.toString(b)); // [10, 9, 8, 7, 14, 16, 4, 3, 2, 1]

        int[] c = { 21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38 };
        heapsort(c, 10);
        System. out.println(Arrays.toString(c)); // [10, 21, 22, 30, 38, 40, 45, 66, 70, 81, 88, 95]
    }

    public static void heapsort(int[] a, final int k) {
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                // a call of Math.abs(a - k) - Math.abs(b - k) should return:
                // if((Math.abs(a - k)-Math.abs(b - k)) < 0) then a comes "before" b in the ordering,
                // if((Math.abs(a - k)-Math.abs(b - k)) > 0) then a comes "after" b in the ordering,
                // if((Math.abs(a - k)-Math.abs(b - k)) == 0) then a and b are considered "equal" in the ordering
                return (int ) (Math.abs(a - k) - Math. abs(b - k));
            }
        };

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(a.length , c);
        for (int i : a) {
            minHeap.add(i);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = minHeap.poll();
        }
    }
}
