package Sorting.BucketSort;

/**
 * Created by yizhao on 7/7/15.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        // in-place swap (bucket sort)
        // Sort array from A[3, 4, -1, 1] to A[1, -1, 3, 4]
        // Sort array from A[3, 4, -1, 1, 2, 2, 2, 2] to A[1, 2, 3, 4, -1, 2, 2, 2]
        // Sort array from A[1, 1] to A[1, 1]
        int i = 0;
        while (i < n) {
            // A[i] > 0 means ingore 0 and negative number because we are looking for missing positive number
            // A[i] - 1 means after sort, A[i] should swap to A[i] - 1 index, so A[i] - 1 need to less than n
            // A[i] != A[A[i] - 1] means A[i] should be in A[i] - 1 index
            while (A[i] > 0 && A[i] - 1 < n && A[i] != A[A[i] - 1]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
            i++;
        }
        // find the first positive missing integer
        i = 0;
        while (i < n && A[i] == i + 1)
            i++;
        return i + 1;
    }
}
