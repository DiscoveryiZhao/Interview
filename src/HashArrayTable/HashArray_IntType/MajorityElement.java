package HashArrayTable.HashArray_IntType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 12/12/14.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] num1 = {1};
        System.out.println(majorityElement(num1)); // 1
        int[] num2 = {1, 2, 3, 2, 2};
        System.out.println(majorityElement(num2)); // 2
        int[] num3 = {3, 1, 2, 3, 2, 3, 3};
        System.out.println(majorityElement(num3)); // 3
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
}
