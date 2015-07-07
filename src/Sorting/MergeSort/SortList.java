package Sorting.MergeSort;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/7/15.
 */
public class SortList {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(4);
        test1.next = new ListNode(9);
        test1.next.next = new ListNode(6);
        test1.next.next.next = new ListNode(1);
        test1.next.next.next.next = new ListNode(2);
        test1.next.next.next.next.next = new ListNode(3);
        test1.next.next.next.next.next.next = new ListNode(5);
        ListNode result1 = sortList(test1);
        // 1->2->3->4->5->6->9->
        while (result1 != null) {
            System.out.print(result1.val + "->");
            result1 = result1.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        // true if only contains 0 or 1 node
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 因为特殊case, 我还说不清楚，
        // 所以这里用fast.next != null && fast.next.next != null而不是fast != null && fast.next != nullW
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;

        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(slow);
        return combine(leftHalf, rightHalf);
    }

    public static ListNode combine(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = (l1 == null ? l2 : l1);
        return dummy.next;
    }
}
