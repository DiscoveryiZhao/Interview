package SlidingWindow.UsingDeque;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yizhao on 7/1/15.
 */
public class SlidingWindowMaximum {
    public static void main(String args[]) {
        int a[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System. out.println(Arrays.toString(maxSlidingWindow(a, 3))); // [3, 3, 5, 5, 6, 7]
    }

    public static int[] maxSlidingWindow(int[] A, int w) {
        int n = A.length ;
        Deque<Integer> leftDeque = new LinkedList<Integer>(); // deque stores index
        int[] res = new int[n - w + 1];
        int right = 0;
        // Initialize deque for first window
        while (right < w) {
            // update deque for first window
            while (!leftDeque.isEmpty() && A[leftDeque.getLast()] <= A[right]) {
                leftDeque.removeLast();
            }
            leftDeque.addLast(right++);
        }

        res[right - w] = A[leftDeque.getFirst()]; // first window res at res[i-w]
        while (right < n) {
            // update deque for new window
            while (!leftDeque.isEmpty() && A[leftDeque.getLast()] <= A[right]) {
                leftDeque.removeLast();
            }
            leftDeque.addLast(right);
            // Pop older element outside window from deque
            while (!leftDeque.isEmpty() && leftDeque.getFirst() <= right - w) {
                leftDeque.removeFirst();
            }
            right++;
            res[right - w] = A[leftDeque.getFirst()];
        }
        return res;
    }
}
