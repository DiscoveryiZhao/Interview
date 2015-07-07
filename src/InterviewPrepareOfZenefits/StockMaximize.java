package InterviewPrepareOfZenefits;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yizhao on 5/6/15.
 */
public class StockMaximize {
    public static void main(String[] args) {
        try {
            StockMaximize();
        } catch (Exception e) {

        }

    }

    private static void StockMaximize() throws IOException {
        List<String> contents = new LinkedList<>();

        Scanner s = new Scanner(new File("/Users/yizhao/Desktop/zenefitTest1.txt"));
        while (s.hasNextLine()) {
            String line = s.nextLine();
            contents.add(line);
            // System.out.println(line);
        }
        int t = contents.size();
        if (t > 0) {
            for (int i = 1; i < t; i++) {
                if (i % 2 == 1) {
                    int n = Integer.parseInt(contents.get(i));
                    i++;
                    String[] sharesPrice = contents.get(i).split(" ");
                    System.out.println("StockMaximize:" + Arrays.toString(sharesPrice));
                    maxProfit(sharesPrice);

                }
            }
        }
    }

    public static void maxProfit(String[] arr) {
        // The idea behind this is iterating arr from right to left and recording the localMax.
        // You always want to buy stocks at low prices and sell them at high, which means higher
        // prices must come after lower prices.
        int n = arr.length, localMax = Integer.parseInt(arr[n - 1]);
        long sum = 0;
        int i;
        for (i = n - 2; i >= 0; --i) {
            if (Integer.parseInt(arr[i]) < localMax) {
                sum += localMax - Integer.parseInt(arr[i]);
            } else {
                localMax = Integer.parseInt(arr[i]);
            }
        }
        System.out.println(sum);
    }


//    public static int maxProfit(String[] prices) {
//        int n = prices.length ;
//        if (n == 0) {
//            return 0;
//        } else {
//            int res = 0;
//            for (int i = 1; i < prices.length; i++) {
//                if (Integer.parseInt(prices[i - 1]) < Integer.parseInt(prices[i])) {
//                    res += Integer.parseInt(prices[i]) - Integer.parseInt(prices[i - 1]);
//                }
//            }
//            return res;
//        }
//    }

//    public static int maxProfit(String[] prices) {
//        int n = prices.length;
//        if (n == 0) {
//            return 0;
//        } else {
//            int opt = 0;
//            int sub = 0;
//            int subMinVal = Integer.parseInt(prices[0]);
//            for (int i = 1; i < n; i++) {
//                subMinVal = Math.min(subMinVal, Integer.parseInt(prices[i]));
//                sub = Integer.parseInt(prices[i]) - subMinVal;
//                opt = Math.max(opt, sub);
//            }
//            return opt;
//        }
//    }
}
