package InterviewPrepareOfGoogle;

import java.util.Arrays;

/**
 * Find next higher number with same digits. Example 1 : if num = 25468, o/p = 25486 Example 2 : if num = 21765, o/p = 25167 Example 3 : If num = 54321, o/p = 54321 (cause it's not possible to gen a higher num than tiz with given digits ).
 */
public class NextHigherNumberWithSameDigit {
    public static void main(String[] args) {
        int[] test1 = {2, 5, 4, 6, 8};
        int[] test2 = {2, 1, 7, 6, 5};
        int[] test3 = {5, 4, 3, 2, 1};
        nextHigherNumber(test1);
        nextHigherNumber(test2);
        nextHigherNumber(test3);

        System.out.println(Arrays.toString(test1)); // [2, 5, 4, 8, 6]
        System.out.println(Arrays.toString(test2)); // [2, 5, 1, 6, 7]
        System.out.println(Arrays.toString(test3)); // [5, 4, 3, 2, 1]
    }

    public static void nextHigherNumber(int[] num) {
        int n = num.length;
        // Case 1: find longest descending tail in range of num[left .. n - 1]
        int left = n - 1;
        while (left > 0 && num[left - 1] >= num[left]) {
            left--;
        }
        if (left == 0) return;  // true if input are all descending order
        reverse(num, left, n - 1);
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
