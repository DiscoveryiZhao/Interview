package Sorting.MergeSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int A[] = { 5, 6, 7, 8, 9, 0, 0, 0, 0, 0 };
        int B[] = { 0, 1, 2, 3, 4 };
        merge(A, 5, B, B.length );
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System. out.println(Arrays.toString(A));
    }

    public static void merge(int A[], int m, int B[], int n) {
        int tail = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] <= B[n]) {
                A[tail--] = B[n--];
            } else {
                A[tail--] = A[m--];
            }
        }

        while (n >= 0)
            A[tail--] = B[n--];
    }
}
