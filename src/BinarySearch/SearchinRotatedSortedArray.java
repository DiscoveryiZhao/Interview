package BinarySearch;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid;

        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[low] < A[mid]) {
                //situation 1, red line
                if (A[low] <= target && target <= A[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                //situation 2, green line
                if (A[mid] <= target && target <= A[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }

        if (A[low] == target) {
            return low;
        }
        if (A[high] == target) {
            return high;
        }
        return -1;
    }
}
