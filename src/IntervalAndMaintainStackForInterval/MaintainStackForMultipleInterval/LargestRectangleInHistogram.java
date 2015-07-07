package IntervalAndMaintainStackForInterval.MaintainStackForMultipleInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] test1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(test1)); // 10
    }

    public static int largestRectangleArea(int[] height) {
        int max = 0;
        Stack<Integer> leftStack = new Stack<>();
        int right = 0;
        while (right < height.length) {
            // right = 1, leftStack = [0], height[index] = 2, width = 1, curArea = 2, max = 2
            // right = 4, leftStack = [1,2,3], height[index] = 6, width = 1, curArea = 6, max = 6
            // right = 4, leftStack = [1,2], height[index] = 5, width = 2, curArea = 10, curArea = 10
            while (!leftStack.isEmpty() && height[leftStack.peek()] > height[right]) {
                max = Math.max(max, height[leftStack.pop()] * (leftStack.isEmpty() ? right : (right - 1 - leftStack.peek())));
            }
            leftStack.push(right++);
        }
        // leftStack = [1,4,5]
        while (!leftStack.isEmpty()) {
            max = Math.max(max, height[leftStack.pop()] * (leftStack.isEmpty() ? right : (right - 1 - leftStack.peek())));
        }
        return max;
    }
}
