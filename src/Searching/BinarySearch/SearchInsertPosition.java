package Searching.BinarySearch;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] test1 = {1, 3, 5, 6};
        int[] test2 = {1};
        System.out.println(searchInsert(test1, 5)); // 2
        System.out.println(searchInsert(test1, 2)); // 1
        System.out.println(searchInsert(test1, 7)); // 4
        System.out.println(searchInsert(test1, 0)); // 0
        System.out.println(searchInsert(test2, 0)); // 0
    }

    public static int searchInsert(int[] A, int target) {
        // take care case of System.out.println(searchInsert(test2,0))
        if (target < A[0]) {
            return 0;
        }

        int low = 0;
        int high = A.length - 1;
        int mid;

        // find the last number less than target
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A[high] == target) {
            return high;
        }

        if (A[high] < target) {
            return high + 1;
        }

        if (A[low] == target) {
            return low;
        }

        return low + 1;
    }
}
