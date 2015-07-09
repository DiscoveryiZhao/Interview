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
        int[] L = new int[m];
        int[] R = new int[n];

        for (int i = 0; i < m; i++)
            L[i] = A[low + i];
        for (int i = 0; i < n; i++)
            R[i] = A[mid + 1 + i];

        int tail = high;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (L[m] <= R[n]) {
                A[tail--] = R[n--];
            } else {
                A[tail--] = L[m--];
            }
        }

        while (n >= 0)
            A[tail--] = R[n--];
    }

}
