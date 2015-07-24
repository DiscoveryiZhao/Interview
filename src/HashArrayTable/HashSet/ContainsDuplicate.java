package HashArrayTable.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 7/24/15.
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
