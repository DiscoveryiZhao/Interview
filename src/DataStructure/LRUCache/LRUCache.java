package DataStructure.LRUCache;

import java.util.HashMap;

/**
 * Created by YZ on 8/23/15.
 */
public class LRUCache {
    private HashMap<Integer, DoubleListNode> map;
    private DoubleListNode head;
    private DoubleListNode tail;
    private int size;
    private int curSize;

    public LRUCache(int size) {
        map = new HashMap<Integer, DoubleListNode>();
        head = null;
        tail = null;
        this.size = size;
        curSize = 0;
    }

    // get(key): int key -> DoubleListNode n -> n.val
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleListNode n = map.get(key);
            deleteNode(n);
            InsertToHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int val) {
        if (map.containsKey(key)) {
            DoubleListNode n = map.get(key);
            n.val = val;
            deleteNode(n);
            InsertToHead(n);
        } else {
            DoubleListNode n = new DoubleListNode(key, val);
            map.put(key, n);
            InsertToHead(n);
            if (curSize < size) {
                curSize++;
            } else {
                // remove tail from map and DoubleLinkedList
                map.remove(tail.key);
                tail = tail.pre;
                tail.next = null;
            }
        }
    }

    // Inserts node to the front of DoubleListNode
    public void InsertToHead(DoubleListNode n) {
        n.pre = null;
        n.next = head;
        // true if empty DoubleLinkedList
        if (head == null && tail == null) {
            head = n;
            tail = n;
        } else { // not empty DoubleLinkedList
            head.pre = n;
            head = n;
        }
    }

    public void deleteNode(DoubleListNode n) {
        if (n.pre == null && n.next != null) { // delete head
            head = head.next; // n.pre == null, then n is head. so delete head
            head.pre = null;
        } else if (n.pre != null && n.next != null) { // delete middle node
            n.pre.next = n.next;
            n.next.pre = n.pre;
        } else if (n.pre != null && n.next == null) { // delete tail
            tail = tail.pre; // n.next == null, then n is tail. so delete tail
            tail.next = null;
        }
    }

    private class DoubleListNode {
        private int val;
        private int key;
        private DoubleListNode pre;
        private DoubleListNode next;

        private DoubleListNode(int key, int val) {
            pre = null;
            next = null;
            this.val = val;
            this.key = key;
        }
    }
}
