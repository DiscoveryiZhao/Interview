package Leetcode.Easy;

import LibraryOfLeetcode.ListNode;

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nt = head.next;
            head.next = newHead;
            newHead = head;
            head = nt;
        }
        return newHead;
    }
}
