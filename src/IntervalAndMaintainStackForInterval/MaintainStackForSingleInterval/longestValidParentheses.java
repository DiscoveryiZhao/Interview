package IntervalAndMaintainStackForInterval.MaintainStackForSingleInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class longestValidParentheses {
    public static void main(String[] args) {
        String test1 = ")(";// 0
        String test2 = "()";// 2
        String test3 = "())";// 2
        String test4 = "(())";// 4
        String test5 = "()()";// 4
        String test6 = "(()()()())";// 10
        String test7 = ")()";// 2
        String test8 = "()())((()))";// 6
        String test9 = "((()(()()()()";// 8
        String test10 = "()(())";// 6
        String test11 = "()(()";// 2
        System. out.println(longestValidParentheses(test1)); // 0
        System. out.println(longestValidParentheses(test2)); // 2
        System. out.println(longestValidParentheses(test3)); // 2
        System. out.println(longestValidParentheses(test4)); // 4
        System. out.println(longestValidParentheses(test5)); // 4
        System. out.println(longestValidParentheses(test6)); // 10
        System. out.println(longestValidParentheses(test7)); // 2
        System. out.println(longestValidParentheses(test8)); // 6
        System. out.println(longestValidParentheses(test9)); // 8
        System. out.println(longestValidParentheses(test10)); // 6
        System. out.println(longestValidParentheses(test11)); // 2
    }

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int start = 0;
        Stack<Integer> leftStack = new Stack<>();
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (c == '(' ) {
                leftStack.push(right);
            } else {
                // true if no matching left
                if (leftStack.isEmpty()) {
                    start = right + 1; // no matching, so move on the the next character
                } else {
                    // find a matching pair
                    leftStack.pop();
                    maxLen = leftStack.isEmpty() ? Math. max(maxLen, right - start + 1) : Math.max(maxLen, right - leftStack.peek());
                }
            }
            right++;
        }
        return maxLen;
    }
}
