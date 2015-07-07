package InterviewPrepareOfGoogle;

import java.util.Arrays;

/**
 * The input is a sequence x1,x2,...,xn of integers in an arbitrary order, and another sequence a1,a2,..,an of distinct integers from 1 to n (namely a1,a2,...,an is a permutation of 1, 2,..., n). Both sequences are given as arrays. Design an 0(n logn) algorithm to order the first sequence according to the order imposed by the permutation. In other words, for each i, Xi should appear in the position given in ai. For example, if x = 17, 5, 1,9, and a = 3, 2, 4, 1, then the outcome should be x = 9, 5, 17, 1. The algorithm should be in-place, so you cannot use an additional array.
 */
public class SortWithAnotherArrayOrder {
    public static void main(String[] args) {
        int[] x = {17, 5, 1, 9};
        int[] a = {3, 2, 4, 1};
        System.out.println(Arrays.toString(sort(x, a))); // [9, 5, 17, 1]
        System.out.println(Arrays.toString(a)); // [1, 2, 3, 4]
    }

    public static int[] sort(int[] x, int[] a) {
        for (int i = 0; i < x.length; i++) {
            while (a[i] != i + 1) {
                // swap x
                int tmp = x[a[i] - 1];
                x[a[i] - 1] = x[i];
                x[i] = tmp;

                // swap a
                tmp = a[i];
                a[i] = a[tmp - 1];
                a[tmp - 1] = tmp;
            }
        }
        return x;
    }

}
