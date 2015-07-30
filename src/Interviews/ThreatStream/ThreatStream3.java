package Interviews.ThreatStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 7/30/15.
 */
public class ThreatStream3 {
    public static void main(String[] args) {
        int[] test1 = {0, 2};
        int[] test2 = {0, 2, -1, 1};
        int[] test3 = {0, -1, -2, 1, 2};

        System.out.println(problem3(test1)); // []
        System.out.println(problem3(test2)); // [[-1, 0, 1]]
        System.out.println(problem3(test3)); // [[-2, 0, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> problem3(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        if (input == null) {
            return result;
        }

        int n = input.length;
        if (n < 3) {
            return result;
        }

        /*
        * Sort the input first so we can use two pointers algorithm approach
        * */
        Arrays.sort(input);
        int a = 0;

        /*
         * define a loop to continue if there still have at less three elements [a..n-2]
         * */
        while (a < n - 2) {
            /*
            * two pointers algorithm approach
            * */
            int b = a + 1;
            int c = n - 1;
            while (b < c) {
                int sum = input[a] + input[b] + input[c];
                if (sum == 0) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(input[a]);
                    subResult.add(input[b]);
                    subResult.add(input[c]);
                    result.add(subResult);
                    b++;
                    c--;
                } else if (sum < 0) {
                    b++;
                } else {
                    c--;
                }
            }
            a++;
        }
        return result;
    }
}
