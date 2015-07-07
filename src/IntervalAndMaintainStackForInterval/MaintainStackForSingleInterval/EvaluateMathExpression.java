package IntervalAndMaintainStackForInterval.MaintainStackForSingleInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class EvaluateMathExpression {
    public static String infixToPostfix(String s) {
        int n = s.length();
        StringBuilder tokens = new StringBuilder();
        Stack<Character> leftStack_operator = new Stack<>();
        int right = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (isOper(c + "")) {
                while (!leftStack_operator.isEmpty() && isOper(leftStack_operator.peek() + "") && getPreced(leftStack_operator.peek()) >= getPreced(c)) {
                    tokens.append(" ");
                    tokens.append(leftStack_operator.pop());
                }
                tokens.append(" ");
                leftStack_operator.push(c);
            } else if (c != ' ') {
                tokens.append(c);
            }
            right++;
        }

        // empty stack
        if (!leftStack_operator.isEmpty()) {
            tokens.append(" ");
            tokens.append(leftStack_operator.pop());
        }

        return Double.toString(evalRPN(tokens.toString().split(" ")));
    }

    public static Double evalRPN(String[] tokens) {
        int n = tokens.length;
        if (n == 0) {
            return -1.0;
        }
        Stack<Double> leftStack = new Stack<>();
        int right = 0;
        while (right < n) {
            String s = tokens[right];
            if (!isOper(s) && !s.equals("")) {
                leftStack.push(Double.valueOf(s));
            } else {
                // true if no matching left
                if (leftStack.isEmpty()) {
                    // do nothing
                } else {
                    double b = leftStack.pop();
                    double a = leftStack.isEmpty() ? 0.0 : leftStack.pop();
                    if (s.equals("+")) {
                        leftStack.push(a + b);
                    } else if (s.equals("-")) {
                        leftStack.push(a - b);
                    } else if (s.equals("*")) {
                        leftStack.push(a * b);
                    } else if (s.equals("/")) {
                        if (b == 0) {
                            leftStack.push(0.0);
                        } else {
                            leftStack.push(a / b);
                        }
                    }
                }
            }
            right++;
        }
        if (leftStack.isEmpty()) {
            return 0.0;
        } else {
            return leftStack.pop();
        }
    }

    private static boolean isOper(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int getPreced(char c) {
        // c == '+' || c == '-' return 1
        // c == '*' || c == '/' return 2;
        return c == '+' || c == '-' ? 1 : 2;
    }
}
