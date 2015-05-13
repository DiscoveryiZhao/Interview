package Leetcode.Easy;

import java.util.Arrays;

/**
 * Created by yizhao on 5/13/15.
 */
public class RotateArray {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums)); // [5,6,7,1,2,3,4]
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length ;
        k = k % n; // handles k > n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] a, int left, int right) {
        while (left < right) {
            swap(a, left++, right--);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
