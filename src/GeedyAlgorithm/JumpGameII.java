package GeedyAlgorithm;

/**
 * Created by yizhao on 7/11/15.
 */
public class JumpGameII {
    // We can use Greedy algorithm here. The basic idea is each time when we
    // jump, we jump to the farthest slot.
    // Start from slot i,
    public static int jump(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int maxCanReach = 0;
        int prevReached = 0;
        int jumpCount = 0;
        for (int i = 0; i < n; i++) {
            if (maxCanReach < i) return 0;
            if (prevReached < i) {
                jumpCount++;
                prevReached = maxCanReach;
            }
            maxCanReach = Math.max(maxCanReach, i + A[i]);
        }
        return jumpCount;
    }
}
