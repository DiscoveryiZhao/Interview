package TwoPointers.SlowFast;

import java.util.ArrayList;
import java.util.List;

/*

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class SummaryRanges {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 4, 5, 7};

        System.out.println(summaryRanges(a)); // [0->2, 4->5, 7]
    }


    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;

        while (r < n) {
            StringBuilder sb = new StringBuilder();
            while (r < n - 1 && nums[r] == nums[r + 1] - 1) {
                r++;
            }
            if (l == r) {
                sb.append(nums[l]);
                res.add(sb.toString());
            } else {
                sb.append(nums[l]);
                sb.append("->");
                sb.append(nums[r]);
                res.add(sb.toString());
            }
            r++;
            l = r;
        }

        return res;
    }
}
