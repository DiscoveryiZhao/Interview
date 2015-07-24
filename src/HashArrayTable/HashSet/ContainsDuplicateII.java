package HashArrayTable.HashSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 7/24/15.
 */
public class ContainsDuplicateII {
    public static void main(String[] args){
        System.out.println(containsNearbyDuplicate(new int[]{99,99}, 0)); // false
        System.out.println(containsNearbyDuplicate(new int[]{99,99}, 1)); // true
        System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2)); // true

        System.out.println(containsNearbyDuplicate(new int[]{99,1,99}, 0)); // false
        System.out.println(containsNearbyDuplicate(new int[]{99,1,99}, 1)); // false
        System.out.println(containsNearbyDuplicate(new int[]{99,1,99}, 2)); // true
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1 || k < 0 || k == 0){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for(int i = 1; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){ // i - map.get(nums[i]) <= k means between i and j is at most k.
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
