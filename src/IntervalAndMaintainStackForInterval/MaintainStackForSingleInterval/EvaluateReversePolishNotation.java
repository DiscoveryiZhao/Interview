package IntervalAndMaintainStackForInterval.MaintainStackForSingleInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        if (n == 0) {
            return -1;
        }
        Stack<Integer> leftStack = new Stack<>();
        int right = 0;
        while (right < n) {
            String s = tokens[right];
            if (!isOper(s)) {
                leftStack.push(Integer.valueOf(s));
            } else {
                // true if no matching left
                if (leftStack.isEmpty()) {
                    // do nothing
                } else {
                    int b = leftStack.pop();
                    int a = leftStack.isEmpty() ? 0 : leftStack.pop();
                    if (s.equals("+")) {
                        leftStack.push(a + b);
                    } else if (s.equals("-")) {
                        leftStack.push(a - b);
                    } else if (s.equals("*")) {
                        leftStack.push(a * b);
                    } else if (s.equals("/")) {
                        if (b == 0) {
                            leftStack.push(0);
                        } else {
                            leftStack.push(a / b);
                        }
                    }
                }
            }
            right++;
        }
        if (leftStack.isEmpty()) {
            return 0;
        } else {
            return leftStack.pop();
        }
    }

    public static boolean isOper(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
