package TwoPointers.ShuangJiBiZhongFa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yizhao on 7/1/15.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        int n = num.length ;
        if (n < 4) {
            return new ArrayList<ArrayList<Integer>>();
        } else {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            Arrays. sort(num);
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    // use two pointers to find the rest of two elements
                    int left = j + 1;
                    int right = n - 1;
                    while (left < right) {
                        int sum = num[i] + num[j] + num[left] + num[right];
                        if(sum == target){
                            ArrayList<Integer> tmp = new ArrayList<Integer>();
                            tmp.add(num[i]);
                            tmp.add(num[j]);
                            tmp.add(num[left]);
                            tmp.add(num[right]);
                            res.add(tmp);
                            // skip duplicates
                            while (left < right && num[left] == num[left + 1]) left++;
                            while (left < right && num[right - 1] == num[right]) right--;
                            left++;
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                    // skip duplicates
                    while (j < n-3 && num[j] == num[j + 1]) j++;
                }
                // skip duplicates
                while (i < n-4 && num[i] == num[i + 1]) i++;
            }
            return res;
        }
    }
}
