package HashArrayTable.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] num1 = {1};
        System.out.println(majorityNumber2(num1)); // 1
        int[] num2 = {1, 2, 3, 2, 2};
        System.out.println(majorityNumber2(num2)); // 2
        int[] num3 = {3, 1, 2, 3, 2, 3, 3};
        System.out.println(majorityNumber2(num3)); // 3
    }

    public static int majorityElement(int[] num) {
        int n = num.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : num) {
            if (hash.containsKey(i)) {
                hash.put(i, hash.get(i) + 1);
            } else {
                hash.put(i, 1);
            }
            if (hash.get(i) > n / 2) {
                return i;
            }
        }
        return num[0];
    }

    public static int majorityNumber2(int[] nums) {
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
