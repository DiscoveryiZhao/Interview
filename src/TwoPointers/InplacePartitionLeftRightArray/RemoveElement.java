package TwoPointers.InplacePartitionLeftRightArray;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3, 4, 5 };
        System. out.println(removeElement(test1, 1)); // 4
        System. out.println(Arrays.toString(test1)); // [2, 3, 4, 5, 5]
    }

    public static int removeElement(int[] A, int elem) {
        int n = A.length ;
        if (n < 1) {
            return n;
        } else {
            int left = -1;
            int right = 0;
            while (right < n) {
                // a[0..left] != element
                if (A[right] != elem) { // find one, skip
                    left++;
                    A[left] = A[right];
                }
                right++;
            }
            return left + 1;
        }
    }
}
