package Interviews.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YZ on 9/4/15.
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


        System.out.println(verifySeparation(input1, 2));
        System.out.println(verifySeparation(input2, 2));

    }


    /*
    *
    * Black-box testing
    * */
    public static boolean verifySeparation(List<String> input, int minDistance) {
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
    }
}
