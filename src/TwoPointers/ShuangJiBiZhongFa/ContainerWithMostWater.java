package TwoPointers.ShuangJiBiZhongFa;

/**
 * Created by yizhao on 7/1/15.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3, 4, 5, 6 }; // 9
        int[] test2 = { 1, 1 }; // 1
        System. out.println(maxArea(test1)); // 9
        System. out.println(maxArea(test2)); // 1
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math. max(maxArea, (right - left) * Math. min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
