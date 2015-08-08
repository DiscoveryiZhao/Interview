package Math.AddSubtractMultiplyDivide;

import Library.Leetcode.ListNode;

/**
 * Created by yizhao on 6/30/15.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        // 2->4->3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        // 5->6->4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + "->"); // 7->0->8
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (l1 != null || l2 != null) {
            int bitSum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;
            carry = bitSum / 10;
            res.next = new ListNode(bitSum % 10);
            res = res.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (carry != 0) {
            res.next = new ListNode(1);
        }
        return dummy.next;
    }
}
