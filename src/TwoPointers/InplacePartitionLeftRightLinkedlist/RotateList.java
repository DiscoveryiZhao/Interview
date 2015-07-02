package TwoPointers.InplacePartitionLeftRightLinkedlist;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        } else {
            int len = length(head);
            k = k % len;

            ListNode left = head;
            ListNode right = head;
            // find the n-to-the-end
            while (right != null) {
                if (k + 1 == 0) {
                    left = left. next;
                } else {
                    k--;
                }
                // right point is at the k = 1
                // make it a circular linked list
                if (right.next == null) {
                    right. next = head;
                    break;
                }
                right = right. next;
            }

            head = left. next;
            left. next = null;
            return head;
        }
    }

    public static int length(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null ) {
            len++;
            cur = cur. next;
        }
        return len;
    }
}
