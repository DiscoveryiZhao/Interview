package Sorting.MergeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 7/7/15.
 */
public class AllUnorderedPairsInArray {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        System.out.println(mergesort(test1)); // []
        int[] test2 = {1, 3, 2};
        System.out.println(mergesort(test2)); // [(3,2)]
        int[] test3 = {3, 2, 1};
        System.out.println(mergesort(test3)); // [(3,2), (3,1), (2,1)]
    }

    public static List<String> mergesort(int[] A) {
        List<String> res = new ArrayList<>();
        conquer(A, 0, A.length - 1, res);
        return res;
    }

    public static void conquer(int[] A, int low, int high, List<String> res) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        conquer(A, low, mid, res);
        conquer(A, mid + 1, high, res);
        combine(A, low, mid, high, res);
    }

    public static void combine(int[] A, int low, int mid, int high, List<String> res) {
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
                res.add("(" + L[m] + "," + R[n] + ")"); // add unordered pair to list
                A[tail--] = L[m--];
            }
        }

        while (n >= 0)
            A[tail--] = R[n--];
    }
}
