package SlidingWindow.UsingVariable;

/**
 * Created by yizhao on 7/5/15.
 */
public class SlidingWindowUsingVarible {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 4, 3, 6};
        int[] b = {2, 1, 1, 4, 3};
        int[] c = {2, 1, 1, 4, 3, 6, 2, 4, 5, 9, 2, 3, 4};
        System.out.println(minimumSequenceSumGreaterThanTarget(a, 8)); // 2
        System.out.println(minimumSequenceSumGreaterThanTarget(b, 8)); // 5
        System.out.println(minimumSequenceSumGreaterThanTarget(c, 8)); // 1
    }

    public static int minimumSequenceSumGreaterThanTarget(int[] a, int targetSum) {
        int n = a.length;
        if (n == 0) {
            return 0;
        } else {
            int minCount = Integer.MAX_VALUE;
            int curSum = 0;
            int L = 0;
            int R = 0;
            while (R < n) {
                // a[L..R-1] satisfy curSum <= targetSum
                while (R < n && curSum <= targetSum) {
                    curSum += a[R++];
                }
                minCount = Math.min(minCount, R - L);
                // find K
                while (curSum > targetSum) {
                    curSum -= a[L++];
                }
                // Handles the result is n
                if (minCount != n) {
                    minCount = Math.min(minCount, R - L + 1);
                }
            }
            // true if all sum less than targetSum
            return minCount == Integer.MAX_VALUE ? 0 : minCount;
        }
    }
}
