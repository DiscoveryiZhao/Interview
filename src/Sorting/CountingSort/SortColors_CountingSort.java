package Sorting.CountingSort;

import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class SortColors_CountingSort {
    public static void main(String[] args) {
        int[] colors = {1, 0, 2, 1, 2, 0, 2, 1, 0, 2};
        sortColors(colors);
        System.out.println(Arrays.toString(colors)); // [0, 0, 0, 1, 1, 1, 2, 2, 2, 2]
    }

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void sortColors(int[] colors) {
        // one-pass for counting
        int[] count = new int[3];
        // count[0,0,0]-> count[3, 3, 4]
        for (int i : colors) {
            ++count[i];
        }

        // fill up the array
        // colors[1, 0, 2, 1, 2, 0, 2, 1, 0, 2] -> colors[0, 0, 0, 1, 2, 0, 2, 1, 0, 2]
        for (int i = 0; i < count[RED]; i++) {
            colors[i] = RED;
        }
        // colors[0, 0, 0, 1, 2, 0, 2, 1, 0, 2] -> colors[0, 0, 0, 1, 1, 1, 2, 1, 0, 2]
        for (int i = count[RED]; i < count[RED] + count[WHITE]; i++) {
            colors[i] = WHITE;
        }
        // colors[0, 0, 0, 1, 1, 1, 2, 1, 0, 2] -> colors[0, 0, 0, 1, 1, 1, 2, 2, 2, 2]
        for (int i = count[RED] + count[WHITE]; i < count[RED] + count[WHITE] + count[BLUE]; i++) {
            colors[i] = BLUE;
        }
    }
}
