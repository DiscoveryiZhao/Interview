package LinkedList.Advanced.ReverseList;

import Library.Leetcode.ListNode;

/**
 * Created by yizhao on 5/19/15.
 */
public class ReverseNodesinKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int tmpK = k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // if k - 1 == 0, then cur is at k
            if (k - 1 == 0) {
                k = tmpK;
                cur = reverse(pre, cur);
                System.out.println(cur.val);
                pre = cur;
            } else {
                k--;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode pre, ListNode end) {
        ListNode cur = pre.next;
        while (pre.next != end) {
            ListNode nt = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = nt;
        }
        return cur;
    }
}
