package Leetcode.Medium;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
public class MaximumProductSubarray {
    public static void main(String[] args){
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums)); // 6
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        min[0] = max[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }

            res = Math.max(res, max[i]);
        }

        return res;
    }
}
