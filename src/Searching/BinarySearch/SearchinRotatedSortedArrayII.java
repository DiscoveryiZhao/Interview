package Searching.BinarySearch;

/**
 * Created by yizhao on 5/17/15.
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args){
        int[] test1 = {1,1,3,1};
        int[] test2 = {3,1,1};
        System.out.println(search(test1, 3)); // true
        System.out.println(search(test2, 3)); // true
    }
    public static boolean search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid;

        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[mid] == A[low]) { // skips duplicates
                low++;
            } else if (A[mid] == A[high]) { // skips duplicates
                high--;
            } else if (A[low] < A[mid]) {
                //situation 1, red line
                if (A[low] <= target && target <= A[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else { // A[low] > A[mid]
                //situation 2, green line
                if (A[mid] <= target && target <= A[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }

        if (A[low] == target) {
            return true;
        }
        if (A[high] == target) {
            return true;
        }
        return false;
    }
}
