package Sorting.QuickSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindtheKclosestElementsToTheTarget {
    public static void main(String[] args) {
        int[] a = { 2, 8, 7, 1, 3, 5, 6, 4 };
        // sorted order: 1,2,3,4,5,6,7,8
        System. out.println(Arrays.toString(findKthLargest(a, 3, 5))); // [5, 4, 6]
        System. out.println(Arrays.toString(a)); // [5, 4, 6, 3, 7, 2, 8, 1]
    }

    public static int[] findKthLargest(int[] a, int k, int target) {
        return conquer(a, 0, a. length - 1, k - 1, target);
    }

    public static int[] conquer(int a[], int low, int high, int k, int target) {
        while (low <= high) {
            int q = partition(a, low, high, target);
            if (q == k) {
                return Arrays.copyOfRange(a, 0, k + 1);
            } else if (q < k) {
                low = q + 1;
            } else { // q > k
                high = q - 1;
            }
        }
        return null ;
    }

    // partition的重点思想概念为，在每此partition过后，a[pivot]左边的数必须小于a[pivot],右边的数必须都大于a[pivot]。
    public static int partition(int[] a, int low, int high, int target) {
        swap(a, low + (int) Math.random () * (high - low + 1), high);
        int pivot = a[high];
        int left = low - 1;
        int right = low;
        while (right < high) {
            // a[0..left] <= pivot
            if (Math.abs(a[right] - target) < Math. abs(pivot - target)) {
                left++;
                swap(a, left, right);
            }
            right++;
        }
        swap(a, left + 1, high);
        return left + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
