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
        int low = 0;
        int high = A.length - 1;
        int mid;

        while(low + 1 < high){
            mid = low + (high - low)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[low]<A[mid]){
                //situation 1, red line
                if(A[low]<=target&&target<=A[mid]){
                    high=mid;
                }else{
                    low=mid;
                }
            }else{
                //situation 2, green line
                if(A[mid]<=target&&target<=A[high]){
                    low = mid;
                }else{
                    high=mid;
                }
            }
        }

        if(A[low]==target){
            return low;
        }
        if(A[high]==target){
            return high;
        }
        return -1;
    }
}
