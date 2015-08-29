package BruteForce;

/**
 * Created by YZ on 8/28/15.
 */
public class MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (i < n) {
            while (j < n && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                result = Math.min(result, j - i);
            }
            sum -= nums[i];
            i++;
        }

        if (result == Integer.MAX_VALUE) {
            result = 0;
        }
        return result;
    }
//    public int minSubArrayLen(int s, int[] nums) {
//        // write your code here
//        int j = 0, i = 0;
//        int sum = 0;
//        int ans = Integer.MAX_VALUE;
//        for (i = 0; i < nums.length; i++) {
//            while (j < nums.length && sum < s) {
//                sum += nums[j];
//                j++;
//            }
//            if (sum >= s) {
//                ans = Math.min(ans, j - i);
//            }
//            sum -= nums[i];
//        }
//        if (ans == Integer.MAX_VALUE) {
//            ans = 0;
//        }
//        return ans;
//    }
}
