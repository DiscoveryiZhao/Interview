package LinkedList.Advanced.ReverseList;

import Library.Leetcode.ListNode;

/**
 * Created by yizhao on 5/19/15.
 */
public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head = pre;
        return head;
    }
}
