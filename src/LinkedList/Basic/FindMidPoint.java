package LinkedList.Basic;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 1/18/15.
 */
public class FindMidPoint {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        test1.next.next.next.next = new ListNode(5);

        System.out.println(findMidPoint(test1).val);
    }

    public static ListNode findMidPoint(ListNode head){
        ListNode walker = head;
        ListNode runner = head;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }
}
