package Leetcode.Medium;

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
        System.out.println(searchInsert(test1, 5)); // 2
        System.out.println(searchInsert(test1, 2)); // 1
        System.out.println(searchInsert(test1, 7)); // 4
        System.out.println(searchInsert(test1, 0)); // 0
    }

    public static int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid;

        if (target < A[0]) {
            return 0;
        }

        // find the last number less than target
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target) {
            return end;
        }

        if (A[end] < target) {
            return end + 1;
        }

        if (A[start] == target) {
            return start;
        }

        return start + 1;
    }
}
