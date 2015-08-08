package LinkedList.Basic;

import Library.Leetcode.ListNode;

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
        ListNode pre = null; // pre等空
        ListNode cur = head; // cur等头
        while (cur != null) { // cur不等空
            ListNode nt = cur.next; // 下等cur下
            // 将cur插入到其之前 //
            cur.next = pre; // cur下等pre
            // 更新指针位置
            pre = cur; // pre等cur
            cur = nt; // cur等下
        }
        head = pre; // 头等pre
        return head;
    }
}
