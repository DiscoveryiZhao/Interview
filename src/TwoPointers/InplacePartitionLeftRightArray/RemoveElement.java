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
            int L = -1;
            int R = 0;
            while (R < n) {
                // a[0..left] != element
                if (A[R] != elem) { // find one, skip
                    L++;
                    A[L] = A[R];
                }
                R++;
            }
            return L + 1;
        }
    }
}
