package Sorting.QuickSort;

/**
 * Created by yizhao on 7/1/15.
 */
public class QuickSort {
    public static void quickSort(int[] a) {
        conquer(a, 0, a.length - 1);
    }

    public static void conquer(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(a, low, high);
        conquer(a, low, q - 1);
        conquer(a, q + 1, high);
    }

    // partition的重点思想概念为，在每此partition过后，a[pivot]左边的数必须小于a[pivot],右边的数必须都大于a[pivot]。
    public static int partition(int[] a, int low, int high) {
        int pivot = a[high]; // Pick pivot point
        int L = low - 1;
        int R = low;
        while (R < high) {
            // a[0..left] <= pivot
            if (a[R] <= pivot) {
                L++;
                swap(a, L, R);
            }
            R++;
        }
        swap(a, L + 1, high);
        return L + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
