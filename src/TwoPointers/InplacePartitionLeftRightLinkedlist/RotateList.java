package TwoPointers.InplacePartitionLeftRightLinkedlist;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = length(head);
        k = k % len;

        ListNode L = head;
        ListNode R = head;
        // find the n-to-the-end
        while (R != null) {
            if (k + 1 == 0) {
                L = L.next;
            } else {
                k--;
            }
            // right point is at the k = 1
            // make it a circular linked list
            if (R.next == null) {
                R.next = head;
                break;
            }
            R = R.next;
        }

        head = L.next;
        L.next = null;
        return head;
    }

    public static int length(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
