package Leetcode.Medium;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
    }

    public static int findMin(int[] nums) {
        return conquer(nums, 0, nums.length - 1);
    }

    public static int conquer(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];
        if ((high - low) == 1)
            return Math.min(nums[low], nums[high]);

        int mid = low + (high - low) / 2;

        // not rotated
        if (nums[low] < nums[high]) {
            return nums[low];

            // go right side
        } else if (nums[mid] > nums[low]) {
            return conquer(nums, mid, high);

            // go left side
        } else {
            return conquer(nums, low, mid);
        }
    }

    public int search(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int mid;

        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[start]<A[mid]){
                //situation 1, red line
                if(A[start]<=target&&target<=A[mid]){
                    end=mid;
                }else{
                    start=mid;
                }
            }else{
                //situation 2, green line
                if(A[mid]<=target&&target<=A[end]){
                    start = mid;
                }else{
                    end=mid;
                }
            }
        }

        if(A[start]==target){
            return start;
        }
        if(A[end]==target){
            return end;
        }
        return -1;
    }
}
