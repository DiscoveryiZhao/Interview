package Sorting.QuickSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindLargestKElementsInUnSortedArray {
    public static void main(String[] args) {
        int[] A = { 8, 4, 6, 3405, 99, 1, 2034, 304 };
        // sorted order: 1,4,6,8,99,304,2034,3405
        System. out.println(Arrays.toString(findKthLargest(A, 8))); // [1, 4, 6, 8, 99, 304, 2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 7))); // [4, 6, 8, 99, 304, 2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 6))); // [6, 8, 99, 304, 2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 5))); // [8, 99, 304, 2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 4))); // [99, 304, 2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 3))); // [304, 2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 2))); // [2034, 3405]
        System. out.println(Arrays.toString( findKthLargest(A, 1))); // [3405]
    }

    public static int[] findKthLargest(int[] A, int k) {
        // Smallest K Elements -> return conquer(A, 0, A.length - 1, k - 1);
        return conquer(A, 0, A. length - 1, A. length - k);
    }

    public static int[] conquer(int A[], int low, int high, int k) {
        while (low <= high) {
            int q = partition(A, low, high);
            if (q == k) {
                // return Arrays.copyOfRange(A, 0, k + 1); <- Smallest K Elements
                return Arrays.copyOfRange(A, k, A. length);
            } else if (q < k) {
                low = q + 1;
            } else { // q > k
                high = q - 1;
            }
        }
        return null ;
    }

    // partition的重点思想概念为，在每此partition过后，a[pivot]左边的数必须小于a[pivot],右边的数必须都大于a[pivot]。
    public static int partition(int[] a, int low, int high) {
        swap(a, low + (int) Math.random () * (high - low + 1), high);
        int pivotVal = a[high];
        int left = low - 1;
        int right = low;
        while (right < high) {
            // a[0..left] <= pivot
            if (a[right] <= pivotVal) {
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
