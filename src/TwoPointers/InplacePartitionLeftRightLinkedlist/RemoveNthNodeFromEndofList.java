package TwoPointers.InplacePartitionLeftRightLinkedlist;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1. next = new ListNode(2);
        test1. next. next = new ListNode(3);
        test1. next. next. next = new ListNode(4);
        test1. next. next. next. next = new ListNode(5);

        ListNode result1 = removeNthFromEnd(test1, 1);
        // 1->2->3->4->
        while (result1 != null) {
            System. out.print(result1.val + "->" );
            result1 = result1. next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;
        while (right != null) {
            if (n + 1 == 0) {
                left = left. next;
            } else {
                n--;
            }
            right = right. next;
        }

        if (n == 0) { // remove head
            head = head. next;
        } else { // remove n- th
            left. next = left. next. next;
        }
        return head;
    }
}
