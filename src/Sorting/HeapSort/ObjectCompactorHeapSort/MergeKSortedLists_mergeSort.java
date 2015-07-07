package Sorting.HeapSort.ObjectCompactorHeapSort;

import LibraryOfLeetcode.ListNode;

import java.util.ArrayList;

/**
 * Created by yizhao on 7/7/15.
 */
public class MergeKSortedLists_mergeSort {
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        } else {
            return conquer(lists, 0, lists.size() - 1);
        }
    }

    private static ListNode conquer(ArrayList<ListNode> lists, int low, int high) {
        if (low != high) {
            int mid = low + (high - low) / 2;
            ListNode left = conquer(lists, low, mid);
            ListNode right = conquer(lists, mid + 1, high);
            return combine(left, right);
        }
        return lists.get(low);
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
