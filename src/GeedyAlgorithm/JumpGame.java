package GeedyAlgorithm;

/**
 * Created by yizhao on 7/11/15.
 */
public class JumpGame {
    public static boolean canJump(int[] A) {
        int n = A.length;
        if (n == 0) {
            return false;
        }
        int maxCanReach = 0;
        for (int i = 0; i < n; i++) {
            if (maxCanReach < i) return false;
            maxCanReach = Math.max(maxCanReach, i + A[i]);
        }
        return true;
    }
}
