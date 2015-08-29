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
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> result1 = diffWaysToCompute(part1);
                List<Integer> result2 = diffWaysToCompute(part2);
                for (Integer n1 : result1) {
                    for (Integer n2 : result2) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                c = n1 + n2;
                                break;
                            case '-':
                                c = n1 - n2;
                                break;
                            case '*':
                                c = n1 * n2;
                                break;
                        }
                        result.add(c);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
