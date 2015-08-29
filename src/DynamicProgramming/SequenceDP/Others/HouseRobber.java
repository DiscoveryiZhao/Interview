package DynamicProgramming.SequenceDP.Others;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobber {
    public static void main(String[] args) {
        int[] a = {1, 1};
        System.out.println(rob(a)); // 1
        int[] b = {1, 2, 3, 4};
        System.out.println(rob(b)); // 6 -> 2 + 4
        int[] c = {1, 3, 5, 7};
        System.out.println(rob(c)); // 10 -> 3 + 7
        int[] d = {1, 3, 5, 2};
        System.out.println(rob(d)); // 6 -> 1 + 5
    }

    /*
    * reference: http://www.programcreek.com/2014/03/leetcode-house-robber-java/
    * */
    public static int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int n = num.length;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = num[0];

        for (int i = 2; i < n + 1; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + num[i - 1]);
        }

        return f[n];
    }
}
