package Math.AppliedMath;

/**
 * Created by YZ on 8/27/15.
 */
public class MissingNumber {
    /*
    * 由题意，大小为n的数组里的所有数都是0 - n之间的数，作为等差数列，
    * 如果没有缺失的时候它的和是能O(1)计算出来的，所以我们遍历一遍记录最大、最小和数组和，
    * 用期望数组和减去实际数组和，就是缺失的整数
    * */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int expectedSum = (1 + n) * n / 2; // 等差数列求和公式: 和=(首项+末项)×项数÷2
        int tmpSum = 0;
        for(int i = 0; i < n; i++){
            tmpSum+=nums[i];
        }
        return expectedSum - tmpSum;
    }
}
