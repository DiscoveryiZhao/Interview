package LinkedList.Advanced.Others;

import LibraryOfLeetcode.RandomListNode;

/**
 * Created by yizhao on 7/7/15.
 */
public class CopyListwithRandomPointer {

    public static RandomListNode copyRandomList(RandomListNode node) {
        if (node == null) {
            return null;
        } else {
            // 第一步，在每个node之后插入一个newNode
            RandomListNode cur = node;
            while (cur != null) {
                RandomListNode newNode = new RandomListNode(cur.label);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = cur.next.next; // NOTE: cur = cur.next.next;
            }

            // 第二步，Node B copy Node A 的Random point
            cur = node;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next; // NOTE: cur = cur.next.next;
            }

            // 第三部： Split Node A 和  Node B， 并以Node B作为res
            cur = node;
            RandomListNode res = cur.next;
            while (cur != null && cur.next != null) {
                RandomListNode nt = cur.next;
                cur.next = cur.next.next;
                cur = nt;
            }
            return res;
        }
    }
}
