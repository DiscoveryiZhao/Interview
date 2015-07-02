package TwoPointers.InplacePartitionLeftRightArray;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy. next = new ListNode(0);
        dummy. next. next = head;

        ListNode left = dummy; // left = low - 1
        ListNode right = dummy. next; // right = low
        while (right.next != null) {
            if (right.next .val < x) { // 题目要求<所以和原来partition的<=有所不同
                      /* left++ */
                left = left. next;
                      /* Swap(left.next,right.next) */
                ListNode temp = right. next;
                right. next = temp. next;
                temp. next = left. next;
                left. next = temp;

                right = left;
            }
            right = right. next;
        }
        return dummy.next .next ;
    }
}
