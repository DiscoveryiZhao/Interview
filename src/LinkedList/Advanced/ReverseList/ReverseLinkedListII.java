package LinkedList.Advanced.ReverseList;

import Library.Leetcode.ListNode;

/**
 * Created by yizhao on 5/19/15.
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int tmpM = m;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        // after while loop pre is at m - 1, cur is at m
        while (cur != null) {
            if (m - 1 == 0) {
                m = tmpM;
                break;
            } else {
                m--;
            }
            pre = cur;
            cur = cur.next;
        }

        // reverse the list
        while (cur != null && cur.next != null && m < n) {
            m++;
            ListNode nt = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = nt;
        }
        return dummy.next;
    }
}
