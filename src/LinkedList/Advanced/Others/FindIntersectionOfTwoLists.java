package LinkedList.Advanced.Others;

import LibraryOfLeetcode.ListNode;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindIntersectionOfTwoLists {
    public static ListNode intersection(ListNode a, ListNode b) {
        int aLength = getLength(a);
        int bLength = getLength(b);

        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                a = a.next;
            }
        } else if (aLength < bLength) {
            for (int i = 0; i < bLength - aLength; i++) {
                b = b.next;
            }
        }

        while (a != b && a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private static int getLength(ListNode cur) {
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
