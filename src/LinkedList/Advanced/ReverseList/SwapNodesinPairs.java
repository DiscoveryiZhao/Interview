package LinkedList.Advanced.ReverseList;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 5/19/15.
 */
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy. next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nt = cur. next. next;
            cur. next. next = pre. next;
            pre. next = cur. next;
            cur. next = nt;
            pre = cur;
            cur = nt;
        }
        return dummy.next ;
    }
}
