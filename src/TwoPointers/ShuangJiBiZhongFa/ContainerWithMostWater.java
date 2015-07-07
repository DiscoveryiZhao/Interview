package TwoPointers.ShuangJiBiZhongFa;

/**
 * Created by yizhao on 7/1/15.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6}; // 9
        int[] test2 = {1, 1}; // 1
        System.out.println(maxArea(test1)); // 9
        System.out.println(maxArea(test2)); // 1
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int L = 0;
        int R = height.length - 1;
        while (L < R) {
            maxArea = Math.max(maxArea, (R - L) * Math.min(height[L], height[R]));
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }
}
