package TwoPointers.InplacePartitionLeftRightArray;

import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] test1 = { 1, 1, 3, 5, 6, 7, 8, 8, 9 };
        System. out.println(removeDuplicates(test1)); // 7
        System. out.println(Arrays.toString(test1)); // [1, 3, 5, 6, 7, 8, 9, 8, 9]
    }

    public static int removeDuplicates(int[] A) {
        int n = A.length ;
        if (n < 2){
            return n;
        } else{
            int left = 0;
            int right = 1;
            while (right < n) {
                // a[0..left] without deplicates
                if (A[left] != A[right]) {
                    left++;
                    A[left] = A[right];
                }
                right++;
            }
            return left + 1;
        }
    }
}
