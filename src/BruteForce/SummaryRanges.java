package BruteForce;

import java.util.ArrayList;
import java.util.List;

/*

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        int start = 0;
        int end = 0;

        while (end < n) {
            StringBuilder sb = new StringBuilder();
            while (end < n - 1 && nums[end] == nums[end + 1] - 1) {
                end++;
            }
            if (start == end) {
                sb.append(nums[start]);
                res.add(sb.toString());
            } else {
                sb.append(nums[start]);
                sb.append("->");
                sb.append(nums[end]);
                res.add(sb.toString());
            }
            end++;
            start = end;
        }

        return res;
    }
}
