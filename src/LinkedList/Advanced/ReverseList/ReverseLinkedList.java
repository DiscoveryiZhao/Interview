package LinkedList.Advanced.ReverseList;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 5/19/15.
 */
public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null ) {
            ListNode nt = cur. next;
            cur. next = pre;
            pre = cur;
            cur = nt;
        }
        head = pre;
        return head;
    }
}
