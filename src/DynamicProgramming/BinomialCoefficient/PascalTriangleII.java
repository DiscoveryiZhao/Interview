package DynamicProgramming.BinomialCoefficient;

import java.util.ArrayList;

/**
 * Created by yizhao on 5/18/15.
 */
public class PascalTriangleII {
    public static void main(String[] args){
        System. out.println(getRow(0)); // [1]
        System. out.println(getRow(1)); // [1, 1]
        System. out.println(getRow(2)); // [1, 2, 1]
        System. out.println(getRow(3)); // [1, 3, 3, 1]
        System. out.println(getRow(4)); // [1, 4, 6, 4, 1]
        System. out.println(getRow(5)); // [1, 5, 10, 10, 5, 1]
        System. out.println(getRow(6)); // [1, 6, 15, 20, 15, 6, 1]
    }

    public static ArrayList<Integer> getRow(int rowIndex) {
        if(rowIndex < 0 ){
            return new ArrayList<Integer>();
        }else{
            ArrayList<Integer> res = new ArrayList<Integer>();
            int[] dp = new int [rowIndex + 1];
            for(int i = 0; i<rowIndex + 1;i++){
                for(int j=i;j>=0;j--){  // since triangle so we do reverse
                    if(j==0 || j==i){
                        dp[j] = 1;
                    } else{
                        dp[j] = dp[j-1] + dp[j];
                    }
                }
            }

            // 将最后结果加入arraylist 并返回
            for(int i: dp){
                res.add(i);
            }
            return res;
        }
    }

}
