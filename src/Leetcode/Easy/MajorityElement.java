package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
        You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class MajorityElement {
    public static void main(String[] args) {
        int[] test1 = {1, 1};
        System.out.println(majorityElement_sol1(test1));
    }

    public static int majorityElement_sol1(int[] nums) {
        int n = nums.length;

        int count = 0;
        int majority = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (nums[i] == majority) {
                count++;
                if (count > nums.length / 2) {
                    return majority;
                }
            } else {
                count--;
            }
        }
        return majority;
    }

    public static int majorityElement_sol2(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) == false) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > n / 2) {
                    return nums[i];
                }
            }
        }
        return nums[0];
    }
}
