// Problem: Remove Linked List Elements (Leetcode #203)
// Link: https://leetcode.com/problems/remove-linked-list-elements/
// Approach: Recursively remove nodes with the given value
// Time Complexity: O(n), Space Complexity: O(n) due to recursion stack

class RemoveElementsFromLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // Recursively call for the next node
        head.next = removeElements(head.next, val);

        // If current node matches the value, skip it
        return head.val == val ? head.next : head;
    }
}
