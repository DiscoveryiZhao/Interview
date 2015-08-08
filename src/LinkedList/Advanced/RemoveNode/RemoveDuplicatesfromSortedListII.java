package LinkedList.Advanced.RemoveNode;

import Library.Leetcode.ListNode;

/**
 * Created by yizhao on 5/19/15.
 */
public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
