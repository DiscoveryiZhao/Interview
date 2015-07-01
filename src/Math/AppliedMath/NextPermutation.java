package Math.AppliedMath;

import java.util.Arrays;

/**
 * Created by yizhao on 6/30/15.
 */
public class NextPermutation {
    public static void main(String[] args) {

        int[] test1 = { 1, 2, 3 };

        int[] test2 = { 3, 2, 1 };

        int[] test3 = { 1, 1, 5 };

        int[] test4 = { 1, 2 };

        int[] test5 = { 5, 4, 7, 5, 3, 2 };

        nextPermutation(test1);

        nextPermutation(test2);

        nextPermutation(test3);

        nextPermutation(test4);

        nextPermutation(test5);

        System. out.println(Arrays.toString(test1)); // [1, 3, 2]

        System. out.println(Arrays.toString(test2)); // [1, 2, 3]

        System. out.println(Arrays.toString(test3)); // [1, 5, 1]

        System. out.println(Arrays.toString(test4)); // [2, 1]

        System. out.println(Arrays.toString(test5)); // [5, 5, 2, 3, 4, 7]

    }

    public static void nextPermutation(int[] num) {

        int n = num.length ;

        // Case 1: find longest descending tail in range of num[left .. n - 1]

        int left = n - 1;

        while (left > 0 && num[left - 1] >= num[left]) {

            left--;

        }

        reverse(num, left, n - 1);

        if (left == 0) return; // true if input are all descending order

        // Case 2: find the first value greater or equal to num[left - 1] in range of num[left .. n - 1]

        int right = left;

        while (num[left - 1] >= num[right]) {

            right++;

        }

        swap(num, left - 1, right);

    }

    private static void reverse(int[] num, int left, int right) {

        while (left < right) {

            swap(num, left++, right--);

        }

    }

    private static void swap(int[] num, int a, int b) {

        int tmp = num[a];

        num[a] = num[b];

        num[b] = tmp;

    }
}
