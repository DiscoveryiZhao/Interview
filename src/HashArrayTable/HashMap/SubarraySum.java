package HashArrayTable.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YZ on 9/6/15.
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] a = {-3, 1, 2, -3, 4};
        System.out.println(subarraySum(a)); // [0, 2]
        int[] b = {7, 1, 2, -3, 4};
        System.out.println(subarraySum(b)); // [1, 3]
    }

    public static ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return res;
    }
}
