package Sorting.HeapSort.ObjectCompactorHeapSort;

import java.util.*;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindtheKelementsClosestToMedian {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(7, 14, 10, 12, 2, 11, 29, 3, 4); // odd length
        List<Integer> b = Arrays.asList(16, 14, 10, 8, 7, 9, 3, 2, 4, 1); // even length
        System.out.println(find_k_closest_to_median(a, 5)); // [10, 11, 12, 7, 14]
        System.out.println(find_k_closest_to_median(b, 5)); // [7, 8, 9, 10, 4]
        System.out.println(find_k_closest_to_median(a, 6)); // [10, 11, 12, 7, 14, 4]
        System.out.println(find_k_closest_to_median(b, 6)); // [7, 8, 9, 10, 4, 3]
    }

    public static List<Integer> find_k_closest_to_median(List<Integer> A, int k) {
        // Find the element i where |A[i] - median| is k- th smallest.
        final double m = find_median(A);
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                // a call of Math.abs(a - m) - Math.abs(b - m) should return:
                // if((Math.abs(a - m)-Math.abs(b - m)) < 0) then a comes "before" b in the ordering,
                // if((Math.abs(a - m)-Math.abs(b - m)) > 0) then a comes "after" b in the ordering,
                // if((Math.abs(a - m)-Math.abs(b - m)) == 0) then a and b are considered "equal" in the ordering
                return (int) (Math.abs(a - m) - Math.abs(b - m));
            }
        };
        Collections.sort(A, c);

        return new ArrayList<Integer>(A.subList(0, k));
    }

    // Promote to double to prevent precision error.
    public static double find_median(List<Integer> A) {
        int mid = A.size() >> 1;
        Collections.sort(A);
        // System.out.println(A);
        if ((A.size() & 1) == 1) { // A has odd number elements.
            return A.get(mid);
        } else { // A has even number elements.
            return (A.get(mid) + A.get(mid - 1)) / 2.0;
        }
    }
}
