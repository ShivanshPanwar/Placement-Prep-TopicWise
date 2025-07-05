// Problem: Reverse Linked List
// Link: https://leetcode.com/problems/reverse-linked-list/
// Description: Reverse a singly linked list using an iterative approach.
// Time Complexity: O(n), Space Complexity: O(1)

public class ReverseLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forward = curr.next; // Store next node
            curr.next = prev;             // Reverse pointer
            prev = curr;                  // Move prev forward
            curr = forward;               // Move curr forward
        }

        return prev; // New head of reversed list
    }
}
