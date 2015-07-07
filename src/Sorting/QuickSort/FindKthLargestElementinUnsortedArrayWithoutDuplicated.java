package Sorting.QuickSort;

/**
 * Created by yizhao on 7/1/15.
 */
public class FindKthLargestElementinUnsortedArrayWithoutDuplicated {
    public static void main(String[] args) {
        int[] A = {304, 4, 6, 8, 99, 1, 2034, 3405};
        System.out.println(findKthLargest(A, 1)); // 1
        System.out.println(findKthLargest(A, 2)); // 4
        System.out.println(findKthLargest(A, 3)); // 6
        System.out.println(findKthLargest(A, 4)); // 8
        System.out.println(findKthLargest(A, 5)); // 99
        System.out.println(findKthLargest(A, 6)); // 304

    }

    public static int findKthLargest(int[] A, int k) {
        // findKthSmallest -> conquer(A, 0, A.length - 1, k - 1)
        // findKthLargest -> conquer(A, 0, A.length - 1, A.length - k)
        return conquer(A, 0, A.length - 1, A.length - k);
    }

    public static int conquer(int A[], int k, int low, int high) {
        while (low <= high) {
            int q = partition(A, low, high);
            if (q == k - 1) {
                return A[q];
            } else if (q < k - 1) {
                low = q + 1;
            } else { // q > k - 1
                high = q - 1;
            }
        }
        return -1;
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
