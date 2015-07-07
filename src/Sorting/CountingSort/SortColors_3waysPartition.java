package Sorting.CountingSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class SortColors_3waysPartition {
    public static void main(String[] args) {
        int[] colors = {1, 0, 2, 1, 2, 0, 2, 1, 0, 2};
        sortColors(colors);
        System.out.println(Arrays.toString(colors)); // [0, 0, 0, 1, 1, 1, 2, 2, 2, 2]
    }

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void sortColors(int[] a) {
        int red = -1;
        int white = 0;
        int blue = a.length - 1;
        while (white <= blue) {
            // a[0..red] are all RED
            if (a[white] == RED) {
                red++;
                swap(a, red, white);
            } else if (a[white] == BLUE) { // a[blue..n-1] are all BLUE
                swap(a, white--, blue--);
            }
            white++;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
