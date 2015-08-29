package Recursion.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
public class DifferentWaystoAddParentheses {
    public static void main(String[] args){
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> resFinal = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return resFinal;
        }

        int n = input.length();
        for (int i = 0; i < n; i++) {
            char operator = input.charAt(i);
            if (operator == '+' || operator == '-' || operator == '*') {
                List<Integer> resL = diffWaysToCompute(input.substring(0, i));
                List<Integer> resR = diffWaysToCompute(input.substring(i + 1));
                for (Integer a : resL) {
                    for (Integer b : resR) {
                        int c = 0;
                        switch (operator) {
                            case '+':
                                c = a + b;
                                break;
                            case '-':
                                c = a - b;
                                break;
                            case '*':
                                c = a * b;
                                break;
                        }
                        resFinal.add(c);
                    }
                }
            }
        }
        if (resFinal.size() == 0) {
            resFinal.add(Integer.valueOf(input));
        }
        return resFinal;
    }
}
