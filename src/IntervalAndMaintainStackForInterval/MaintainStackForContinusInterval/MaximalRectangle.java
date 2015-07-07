package IntervalAndMaintainStackForInterval.MaintainStackForContinusInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        // Rolling Array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 如果为1， 则这格是上一格加上1。
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            maxArea = Math.max(largestRectangleArea(height), maxArea);
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] height) {
        int max = 0;
        Stack<Integer> leftStack = new Stack<>();
        int right = 0;
        while (right < height.length) {
            while (!leftStack.isEmpty() && height[leftStack.peek()] > height[right]) {
                max = Math.max(max, height[leftStack.pop()] * (leftStack.isEmpty() ? right : (right - 1 - leftStack.peek())));
            }
            leftStack.push(right++);
        }

        while (!leftStack.isEmpty()) {
            max = Math.max(max, height[leftStack.pop()] * (leftStack.isEmpty() ? right : (right - 1 - leftStack.peek())));
        }
        return max;
    }
}
