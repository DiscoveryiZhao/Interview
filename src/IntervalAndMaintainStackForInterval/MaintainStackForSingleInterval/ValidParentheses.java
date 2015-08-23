package IntervalAndMaintainStackForInterval.MaintainStackForSingleInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String test1 = ")(";// false
        String test2 = "()";// true
        String test3 = "())";// false
        String test4 = "(())";// true
        String test5 = "()()";// true
        String test6 = "(()()()())";// true
        String test7 = "()[]{}";// true

        System.out.println(isValid(test1)); // false
        System.out.println(isValid(test2)); // true
        System.out.println(isValid(test3)); // false
        System.out.println(isValid(test4)); // true
        System.out.println(isValid(test5)); // true
        System.out.println(isValid(test6)); // true
        System.out.println(isValid(test7)); // true
    }

    public static boolean isValid(String s) {
        int n = s.length();
        // odd length is not possible as valid parentheses
        if ((n % 2) == 1) {
            return false;
        }

        Stack<Character> leftStack = new Stack<>();
        int right = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (c == '(' || c == '[' || c == '{') {
                leftStack.push(c);
            } else {
                // true if no matching left
                if (leftStack.isEmpty()) {
                    return false;
                } else {
                    char popChar = leftStack.pop();
                    if(popChar == '(' && c != ')' ){
                        return false;
                    }
                    if(popChar == '[' && c != ']' ){
                        return false;
                    }
                    if(popChar == '{' && c != '}' ){
                        return false;
                    }
                }
            }
            right++;
        }
        return leftStack.isEmpty();
    }
}
