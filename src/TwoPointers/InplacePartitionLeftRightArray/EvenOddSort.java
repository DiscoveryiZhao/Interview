package TwoPointers.InplacePartitionLeftRightArray;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class EvenOddSort {
    public static void main(String[] args) {
        int[] a = { 2, 1, 4, 5, 1, 2, 5, 6, 4, 3, 4, 3 };
        oddEven(a);
        // [1, 5, 1, 5, 3, 3, 2, 6, 4, 4, 4, 2]
        System. out.println(Arrays.toString(a));
    }

    public static void oddEven(int[] a) {
        int n = a.length ;
        int left = -1;
        int right = 0;
        while (right < n) {
            // a[0..left] 都为odd number
            if ((a[right] & 1) == 1) {
                left++;
                swap(a, left, right);
            }
            right++;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
