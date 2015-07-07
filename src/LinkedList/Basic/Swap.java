package LinkedList.Basic;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 1/18/15.
 */
public class Swap {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        test1.next.next.next.next = new ListNode(5);

        swap(test1.next.next, test1.next.next.next);

        while (test1 != null) {
            System.out.print(test1.val + "->");
            test1 = test1.next;
        }
        System.out.println();
    }

    public static void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
}
