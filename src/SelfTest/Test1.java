package SelfTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 5/2/15.
 */
public class Test1 {
    // [2],
// [3,4],
// [6,5,7],
// [4,1,8,3]
    public static void main(String[] args) {
        List<String> res = summaryRanges(new int[]{0,1,2,4,5,7});
        System.out.println(res);
    }

//    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0) {
//            return 0;
//        }
//
//        int n = triangle.size();
//        int[][] sum = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            sum[n - 1][i] = triangle.get(n - 1).get(i);
//        }
//
//        for(int i=0; i < n; i++){
//            System.out.println(Arrays.toString(sum[i]));
//        }
//
//        System.out.println();
//
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = 0; j <= i; j++) {
//                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
//            }
//            for(int k=0; k < n; k++){
//                System.out.println(Arrays.toString(sum[k]));
//            }
//            System.out.println();
//        }
//
//        return sum[0][0];
//    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums==null||nums.length==0){
            return result;
        }
        int max = nums[0];
        int min = nums[0];
        int i = 1;
        while(i < nums.length){
            if(nums[i]==nums[i-1] + 1){
                max = nums[i];
            }else{
                result.add(min + "->" + max);
                min=nums[i];
                max=nums[i];
            }
            i++;
        }
        return result;
    }
}
