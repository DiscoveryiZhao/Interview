package LinkedList.Basic;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 1/18/15.
 */
public class RemoveNodeFromLinkedList {

    public ListNode removeNodeFromLinkedList(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preHead = dummy;

        while (head != null) {
            if (head.val == target) {
                preHead.next = preHead.next.next;
                break;
            }
            head = head.next;
            preHead = preHead.next;
        }

        return dummy.next;
    }
}
