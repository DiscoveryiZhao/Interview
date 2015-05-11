package Leetcode.Easy;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 5/11/15.
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return null;
        } else {

            ListNode cur = head;
            while (cur != null && cur.next != null) {
                ListNode nt = cur.next;
                if (nt.val == val) {
                    cur.next = nt.next;
                } else {
                    cur = cur.next;
                }

            }
            return head;
        }
    }
}
