package Leetcode.Easy;

import LibraryOfLeetcode.ListNode;

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        ListNode res1 = removeElements(test1, 1);
        while (res1 != null) {
            System.out.print(res1.val);
            System.out.print("->");
            res1 = res1.next;
        }

        System.out.println();

        ListNode test2 = new ListNode(1);
        test2.next = new ListNode(1);
        ListNode res2 = removeElements(test2, 1);
        while (res2 != null) {
            System.out.print(res2.val);
            System.out.print("->");
            res2 = res2.next;
        }
    }

//

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }
}
