package Searching.BinarySearch;

import java.util.Arrays;

/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class SearchforaRange {
    public static void main(String[] args) {
        int[] test1 = {5, 7, 7, 8, 8, 10};
        int[] test2 = {2, 2};
        int[] test3 = {3, 3, 3};
        int[] test4 = {1, 2, 2};
        int[] test5 = {1, 2, 3, 3, 3, 3, 4, 5, 9};
        System.out.println(Arrays.toString(searchRange(test1, 8))); // [3, 4]
        System.out.println(Arrays.toString(searchRange(test2, 2))); // [0, 1]
        System.out.println(Arrays.toString(searchRange(test3, 3))); // [0, 2]
        System.out.println(Arrays.toString(searchRange(test4, 2))); // [1, 2]
        System.out.println(Arrays.toString(searchRange(test5, 3))); // [2, 5]
    }


    public static int[] searchRange(int[] A, int target) {
        int[] range = {-1, -1};

        // search for left range
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                high = mid;
            } else if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A[low] == target) {
            range[0] = low;
        } else if (A[high] == target) {
            range[0] = high;
        }else {
            range[0] = range[1] = -1;
            return range;
        }

        // search for right range
        low = 0;
        high = A.length - 1;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                low = mid;
            } else if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A[high] == target) {
            range[1] = high;
        } else if (A[low] == target) {
            range[1] = low;
        }else {
            range[0] = range[1] = -1;
            return range;
        }

        return range;
    }
}
