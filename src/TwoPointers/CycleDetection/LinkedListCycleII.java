package TwoPointers.CycleDetection;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow. next;
            fast = fast. next. next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    fast = fast. next;
                    slow = slow. next;
                }
                return slow;
            }
        }
        return null ;
    }
}
