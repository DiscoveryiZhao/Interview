package TwoPointers.ShuangJiBiZhongFa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length ;
        if (n < 3) {
            return new ArrayList<ArrayList<Integer>>();
        } else {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            Arrays. sort(num);
            for (int i = 0; i < n - 2; i++) {
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = num[i] + num[left] + num[right];
                    if(sum == 0){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        res.add(tmp);
                        // skip duplicates
                        while (left < right && num[left] == num[left + 1]) left++;
                        while (left < right && num[right - 1] == num[right]) right--;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else { // sum > 0
                        right--;
                    }
                }

                // skip duplicates
                while (i < n-3 && num[i] == num[i + 1]) i++;
            }
            return res;
        }
    }
}
