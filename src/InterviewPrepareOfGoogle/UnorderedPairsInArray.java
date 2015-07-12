package InterviewPrepareOfGoogle;

import java.util.ArrayList;

/**
 * Created by yizhao on 7/12/15.
 */
public class UnorderedPairsInArray {
    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3 };
        System. out.println(mergesort(test1)); // []
        int[] test2 = { 1, 3, 2 };
        System. out.println(mergesort(test2)); // [(3,2)]
        int[] test3 = { 1,3,2,4,0};
        System. out.println(mergesort(test3)); // [(3,2), (3,1), (2,1)]
    }

    public static ArrayList<String> mergesort(int[] A) {
        ArrayList<String> res = new ArrayList<String>();
        conquer(A, 0, A.length - 1, res);
        return res;
    }

    public static void conquer(int[] A, int low, int high, ArrayList<String> res) {
        if (low != high) {
            int mid = low + (high - low) / 2;
            conquer(A, low, mid, res);
            conquer(A, mid + 1, high, res);
            combine(A, low, mid, high, res);
        }
    }

    public static void combine(int[] A, int low, int mid, int high, ArrayList<String> res) {
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
                res.add( "(" + left[m] + "," + right[n] + ")"); // add unordered pair to list
                A[tail--] = left[m--];
            }
        }

        while (n >= 0)
            A[tail--] = right[n--];
    }
}
