package Leetcode.Easy;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 5/13/15.
 */
public class IntersectionofTwoLinkedLists {
    public static void main(String[] args){
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);


        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = new ListNode(3);
        headB.next.next.next = new ListNode(4);
        headB.next.next.next.next = new ListNode(5);

        ListNode res = getIntersectionNode(headA,headB);
        while(res!=null){
            System.out.print(res.val);
            System.out.print("->");
            res = res.next;
        }
    }
    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        int aLength = getLength(a);
        int bLength = getLength(b);

        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                a = a. next;
            }
        } else if (aLength < bLength) {
            for (int i = 0; i < bLength - aLength; i++) {
                b = b. next;
            }
        }

        while (a != b && a != null && b != null) {
            a = a. next;
            b = b. next;
        }
        return a;
    }

    private static int getLength(ListNode cur){
        int length = 0;
        while (cur != null ) {
            length++;
            cur = cur. next;
        }
        return length;
    }
}
