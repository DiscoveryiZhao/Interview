package TwoPointers.InplacePartitionLeftRightArray;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] test1 = { 1, 1, 1, 2, 2, 3 };
        System. out.println(removeDuplicates(test1)); // 5
        System. out.println(Arrays.toString(test1)); // [1, 1, 2, 2, 3, 3]
    }

    public static int removeDuplicates(int[] A) {
        int n = A.length ;
        if (n < 3) {
            return n;
        } else {
            int left = 1;
            int right = 2;
            while (right < n) {
                // a[0..left] without more than twice of deplicates
                if (!(A[left-1] == A[right] && A[left] == A[right])) {
                    left++;
                    A[left] = A[right];
                }
                right++;
            }
            return left + 1;
        }
    }
}
