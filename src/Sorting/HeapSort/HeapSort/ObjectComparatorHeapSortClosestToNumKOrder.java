package Sorting.HeapSort.HeapSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yizhao on 7/7/15.
 */
public class ObjectComparatorHeapSortClosestToNumKOrder {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(7, 14, 10, 12, 2, 11, 29, 3, 4);
        heapsort(a, 10);
        System.out.println(a); // [10, 11, 12, 7, 14, 4, 3, 2, 29]

        List<Integer> b = Arrays.asList(4, 1, 3, 2, 16, 9, 10, 14, 8, 7);
        heapsort(b, 10);
        System.out.println(b); // [10, 9, 8, 7, 14, 4, 16, 3, 2, 1]

        List<Integer> c = Arrays.asList(21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38);
        heapsort(c, 10);
        System.out.println(c); // [10, 21, 22, 30, 38, 40, 45, 66, 70, 81, 88, 95]
    }

    public static void heapsort(List<Integer> A, final int k) {
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                // a call of Math.abs(a - k) - Math.abs(b - k) should return:
                // if((Math.abs(a - k)-Math.abs(b - k)) < 0) then a comes "before" b in the ordering,
                // if((Math.abs(a - k)-Math.abs(b - k)) > 0) then a comes "after" b in the ordering,
                // if((Math.abs(a - k)-Math.abs(b - k)) == 0) then a and b are considered "equal" in the ordering
                return (int) (Math.abs(a - k) - Math.abs(b - k));
            }
        };
        Collections.sort(A, c);
    }

}
