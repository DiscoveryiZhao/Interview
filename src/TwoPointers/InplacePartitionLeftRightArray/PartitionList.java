package TwoPointers.InplacePartitionLeftRightArray;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/1/15.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(0);
        dummy.next.next = head;

        ListNode L = dummy; // left = low - 1
        ListNode R = dummy.next; // right = low
        while (R.next != null) {
            if (R.next.val < x) { // 题目要求<所以和原来partition的<=有所不同
                      /* left++ */
                L = L.next;
                      /* Swap(left.next,right.next) */
                ListNode temp = R.next;
                R.next = temp.next;
                temp.next = L.next;
                L.next = temp;

                R = L;
            }
            R = R.next;
        }
        return dummy.next.next;
    }
}
