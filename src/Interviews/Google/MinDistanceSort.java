package Interviews.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：
 * input为： List<String> list, int minDistance
 * [A, B, B], 2 -> [B, A, B]
 *     ^  ^         ^     ^
 *     1  2         0     2   (2 - 0 >= 2)
 * [A, B, B], 1 -> (any permutation, including the input)
 * [A, B, B], 3 -> (no solution; throw exception, return error code)
 *
 * 如果两个相同element的index间距 < minDistance，则要求输出任意的permutation使得这2个element的index间距不会小于minDistance。
 * it's ok if 两个相同element的index间距 >= minDistance
 */
public class MinDistanceSort {
    public static void main(String[] args){
        List<String> input1 = new ArrayList<>();
        input1.add("A");
        input1.add("B");
        input1.add("C");
        input1.add("D");
        input1.add("E");
        input1.add("F");
        input1.add("F");

        List<String> input2 = new ArrayList<>();
        input2.add("A");
        input2.add("B");
        input2.add("C");
        input2.add("D");
        input2.add("E");
        input2.add("F");
        input2.add("A");


        System.out.println(sol(input1, 2));
        System.out.println(sol(input2, 2));

    }

    public static List<String> sol(List<String> input, int minDistance){
        for (int i = 0; i < input.size(); i++) {
            int separateDistance = verifySeparation(input, minDistance);
            if (separateDistance > 0) {
                swap(input, i,separateDistance );
            }
        }
        return input;
    }


    /*
    *
    * Black-box testing
    * */
    public static int verifySeparation(List<String> input, int minDistance) {
        // String: element from the input
        // Integer: index at which that element last appeared
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            if (map.containsKey(s) == false) {
                map.put(s, i);
            } else {
                int curDistance = i - map.get(s);
                map.put(s, i);
                if (curDistance < minDistance) {
                    return curDistance;
                }
            }
        }
        return 0;
    }
/*    public static boolean verifySeparation(List<String> input, int minDistance) {
    // String: element from the input
    // Integer: index at which that element last appeared
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            if (map.containsKey(s) == false) {
                map.put(s, i);
            } else {
                int curDistance = i - map.get(s);
                map.put(s, i);
                if (curDistance < minDistance) {
                    return false;
                }
            }
        }
        return true;
    }*/

    private static void swap(List<String> input, int i, int j){
        String tmp = input.get(i);
        input.set(i,input.get(j));
        input.set(j, tmp);
    }
}
