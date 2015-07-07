package Searching.BinarySearch;

/**
 * Created by yizhao on 6/21/15.
 */
public class FindTheIndexOfTheNumberClosestToXinSortedArray {
    public static void main(String[] args) {
        int[] a = { 3, 6, 7, 9, 20, 41, 46, 60, 62, 70 };
        System. out.println(findTheIndexOfTheNumberClosestToX(a, 43)); // 5
        System. out.println(findTheIndexOfTheNumberClosestToX(a, 44)); // 6
    }

    public static int findTheIndexOfTheNumberClosestToX( int[] a, int x) {
        int low = -1;
        int high = a.length ;
        int res = 0;
        while (low + 1 < high) {
            // Invariant: a[low] < target < a[high], and a[mid] == target
            int mid = low + (high - low) / 2;
            if (Math.abs(a[mid] - x) < Math. abs(a[res] - x)) {
                res = mid;
            }
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return res;
    }
}
