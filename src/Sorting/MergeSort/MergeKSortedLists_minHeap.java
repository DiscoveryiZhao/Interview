package Sorting.MergeSort;

import LibraryOfLeetcode.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yizhao on 7/7/15.
 */
public class MergeKSortedLists_minHeap {
    public static void main(String[] args) {
        // 5->6->7->8->9->null
        ListNode test1 = new ListNode(5);
        test1. next = new ListNode(6);
        test1. next. next = new ListNode(7);
        test1. next. next. next = new ListNode(8);
        test1. next. next. next. next = new ListNode(9);

        // 0->1->2->3->4->null
        ListNode test2 = new ListNode(0);
        test2. next = new ListNode(1);
        test2. next. next = new ListNode(2);
        test2. next. next. next = new ListNode(3);
        test2. next. next. next. next = new ListNode(4);

        // 2->3->4->6->8->null
        ListNode test3 = new ListNode(2);
        test3. next = new ListNode(3);
        test3. next. next = new ListNode(4);
        test3. next. next. next = new ListNode(6);
        test3. next. next. next. next = new ListNode(8);

        ArrayList<ListNode> testTotal1 = new ArrayList<ListNode>();
        testTotal1.add(test1);
        testTotal1.add(test3);
        testTotal1.add(test2);

        // output: 0->1->2->2->3->3->4->4->5->6->6->7->8->8->9->
        ListNode result = mergeKLists(testTotal1);
        while (result != null) {
            System. out.print(result.val + "->" );
            result = result. next;
        }
        System. out.println();
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null ;
        } else {
            Comparator<ListNode> c = new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val ;
                }
            };

            // new PriorityQueue<ListNode>(heapSize, c)
            PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), c);
            for (ListNode node : lists) {
                if (node != null) {
                    minHeap.add(node);
                }
            }

            ListNode head = minHeap.poll();
            ListNode cur = null;
            while (!minHeap.isEmpty()) {
                if (cur == null ) {
                    cur = head;
                } else {
                    cur. next = minHeap.poll();
                    cur = cur. next;
                }

                // next node of the cur list is not null, then we add to minHeap
                if (cur != null && cur.next != null) {
                    minHeap.add(cur. next);
                }
            }
            return head;
        }
    }
}
