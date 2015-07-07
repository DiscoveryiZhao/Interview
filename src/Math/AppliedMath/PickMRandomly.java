package Math.AppliedMath;

import java.util.Arrays;

/**
 * Created by yizhao on 6/30/15.
 */
public class PickMRandomly {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(pickMRandomly(a, 4))); // [8, 3, 1, 2]
    }

    public static int[] pickMRandomly(int[] a, int m) {
        for (int i = 0; i < m; i++) {
            swap(a, i, rand(i, a.length - 1));
        }
        return Arrays.copyOfRange(a, 0, m);
    }

    public static int rand(int low, int high) {
        // generate a random number between [low, high - low]
        return low + (int) (Math.random() * (high - low + 1));
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
