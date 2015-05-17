package BinarySearch;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums)); // 0
    }

    public static int findMin(int[] num) {
        int low = 0;
        int high = num.length - 1;
        int mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (num[mid] >= num[high]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (num[low] < num[high]) {
            return num[low];
        } else {
            return num[high];
        }
    }
}
