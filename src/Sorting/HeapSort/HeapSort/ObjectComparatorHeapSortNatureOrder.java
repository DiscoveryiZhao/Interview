package Sorting.HeapSort.HeapSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yizhao on 7/7/15.
 */
public class ObjectComparatorHeapSortNatureOrder {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(7, 14, 10, 12, 2, 11, 29, 3, 4);
        heapsort(a);
        System.out.println(a); // [2, 3, 4, 7, 10, 11, 12, 14, 29]

        List<Integer> b = Arrays.asList(4, 1, 3, 2, 16, 9, 10, 14, 8, 7);
        heapsort(b);
        System.out.println(b); // [1, 2, 3, 4, 7, 8, 9, 10, 14, 16]

        List<Integer> c = Arrays.asList(21, 66, 40, 10, 70, 81, 30, 22, 45, 95, 88, 38);
        heapsort(c);
        System.out.println(c); // [10, 21, 22, 30, 38, 40, 45, 66, 70, 81, 88, 95]
    }

    public static void heapsort(List<Integer> A) {
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                // a call of a - b should return:
                // if((a-b) < 0) then a comes "before" b in the ordering,
                // if((a-b) > 0) then a comes "after" b in the ordering,
                // if((a-b) == 0) then a and b are considered "equal" in the ordering
                return a - b;
            }
        };
        Collections.sort(A, c);
    }
}
