package SlidingWindow.UsingDeque;

import java.util.*;

/*
        Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

        For example,
        Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
        Therefore, return the max sliding window as [3,3,5,5,6,7].

        Note:
        You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

        Follow up:
        Could you solve it in linear time?
*/
public class SlidingWindowMaximum {
    public static void main(String args[]) {
        int a[] = {5, 4, 3, 2, 1};
        int b[] = {1,3,2};
        System.out.println(maxSlidingWindow_lintcode(a, 3)); // [5, 5, 5]
        System.out.println(maxSlidingWindow_lintcode(b, 1)); // [1, 3, 2]
    }

    public static ArrayList<Integer> maxSlidingWindow_lintcode(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            // while ((!deque.isEmpty() && nums[0] > deque.peekLast()))
            while ((!deque.isEmpty() && nums[i] > deque.peekLast())) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);

            //if (k > 0 && deque.peekFirst() == nums[k])
            if (i - k > 0 && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }

            // if (k <= 1)
            if (k <= i + 1) {
                res.add(deque.peekFirst());
            }

        }
        return res;
    }

    public static int[] maxSlidingWindow_leetcode(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;

        for (int now : nums) {
            i++;

            while ((!deque.isEmpty() && now > deque.peekLast())) {
                deque.pollLast();
            }
            deque.addLast(now);
            if (i > k && deque.peekFirst() == nums[i - k - 1]) {
                deque.pollFirst();
            }
            if (i > k - 1) {
                res[i - k] = deque.peekFirst();
            }

        }
        return res;
    }

//    public static int[] maxSlidingWindow(int[] A, int w) {
//        int n = A.length;
//        Deque<Integer> leftDeque = new LinkedList<Integer>(); // deque stores index
//        int[] res = new int[n - w + 1];
//        int right = 0;
//        // Initialize deque for first window
//        while (right < w) {
//            // update deque for first window
//            while (!leftDeque.isEmpty() && A[leftDeque.getLast()] <= A[right]) {
//                leftDeque.removeLast();
//            }
//            leftDeque.addLast(right++);
//        }
//
//        res[right - w] = A[leftDeque.getFirst()]; // first window res at res[i-w]
//        while (right < n) {
//            // update deque for new window
//            while (!leftDeque.isEmpty() && A[leftDeque.getLast()] <= A[right]) {
//                leftDeque.removeLast();
//            }
//            leftDeque.addLast(right);
//            // Pop older element outside window from deque
//            while (leftDeque.getFirst() <= right - w) {
//                leftDeque.removeFirst();
//            }
//            right++;
//            res[right - w] = A[leftDeque.getFirst()];
//        }
//        return res;
//    }


}
