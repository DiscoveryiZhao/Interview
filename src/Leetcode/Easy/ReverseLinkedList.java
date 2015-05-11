package Leetcode.Easy;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 5/11/15.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode nt = head.next;
            head.next = newHead;
            newHead = head;
            head = nt;
        }
        return newHead;
    }
}
