package Sorting.MergeSort;

/**
 * Created by yizhao on 7/7/15.
 */
public class MergeSort {
    public static void mergesort(int[] A) {
        conquer(A, 0, A.length - 1);
    }

    public static void conquer(int[] A, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        conquer(A, low, mid);
        conquer(A, mid + 1, high);
        combine(A, low, mid, high);
    }

    public static void combine(int[] A, int low, int mid, int high) {
        int m = mid - low + 1, n = high - mid;
        int[] left = new int[m];
        int[] right = new int[n];

        for (int i = 0; i < m; i++)
            left[i] = A[low + i];
        for (int i = 0; i < n; i++)
            right[i] = A[mid + 1 + i];

        int tail = high;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (left[m] <= right[n]) {
                A[tail--] = right[n--];
            } else {
                A[tail--] = left[m--];
            }
        }

        while (n >= 0)
            A[tail--] = right[n--];
    }

}
