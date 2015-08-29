package TwoPointers.SlowFast;

/*      Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

        For example, given the array [2,3,1,2,4,3] and s = 7,
        the subarray [4,3] has the minimal length under the problem constraint.

        click to show more practice.

        More practice:
        If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).*/
public class MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s:    an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        while (l < n) {
            while (r < n && sum < s) {
                sum += nums[r];
                r++;
            }
            if (sum >= s) {
                res = Math.min(res, r - l);
            }
            sum -= nums[l];
            l++;
        }

        if (res == Integer.MAX_VALUE) {
            res = 0;
        }
        return res;
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
