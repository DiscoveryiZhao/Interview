package TwoPointers.InplacePartitionLeftRightArray;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] test1 = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(test1)); // 5
        System.out.println(Arrays.toString(test1)); // [1, 1, 2, 2, 3, 3]
    }

    public static int removeDuplicates(int[] A) {
        int n = A.length;
        if (n < 3) {
            return n;
        }
        int L = 1;
        int R = 2;
        while (R < n) {
            // a[0..left] without more than twice of deplicates
            if (!(A[L - 1] == A[R] && A[L] == A[R])) {
                L++;
                A[L] = A[R];
            }
            R++;
        }
        return L + 1;
    }
}
