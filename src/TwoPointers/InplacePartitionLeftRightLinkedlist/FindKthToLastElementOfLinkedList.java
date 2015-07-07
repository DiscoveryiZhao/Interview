package TwoPointers.InplacePartitionLeftRightLinkedlist;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class FindKthToLastElementOfLinkedList {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        test1.next.next.next.next = new ListNode(5);

        ListNode result1 = findKthNodeinLinkedList(test1, 1);
        System.out.print(result1.val); // 5
        ListNode result2 = findKthNodeinLinkedList(test1, 2);
        System.out.print(result2.val); // 4
        ListNode result3 = findKthNodeinLinkedList(test1, 3);
        System.out.print(result3.val); // 3
        ListNode result4 = findKthNodeinLinkedList(test1, 4);
        System.out.print(result4.val); // 2
        ListNode result5 = findKthNodeinLinkedList(test1, 5);
        System.out.print(result5.val); // 1
    }

    public static ListNode findKthNodeinLinkedList(ListNode head, int k) {
        if (k == 0) {
            return null;
        } else {
            ListNode L = head;
            ListNode R = head;
            while (R != null) {
                if (k == 0) {
                    L = L.next;
                } else {
                    k--;
                }
                R = R.next;
            }
            // Handles k> list.length
            // when k > list.length, k would great then 0 after while loop
            if (k > 0) {
                return null;
            }
            return L;
        }
    }
}
