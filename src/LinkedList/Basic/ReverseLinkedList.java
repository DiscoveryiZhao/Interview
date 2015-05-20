package LinkedList.Basic;

import Leetcode.Library.ListNode;

/**
 * Created by yizhao on 1/18/15.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(3);
        test1.next.next.next = new ListNode(4);
        test1.next.next.next.next = new ListNode(5);

        ListNode test1Result = reverseLinkedList(test1);
        while (test1Result != null) {
            System.out.print(test1Result.val + "->");
            test1Result = test1Result.next;
        }
        System.out.println();
    }


    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nt = cur.next;
            // 将cur插入到其之前
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nt;
        }
        head = pre;
        return head;
    }
}
