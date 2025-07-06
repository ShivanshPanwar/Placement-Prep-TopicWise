// Problem: Remove Duplicates from Sorted List (Leetcode #83)
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Approach: One-pass iteration
// Time Complexity: O(n), Space Complexity: O(1)

class RemoveDuplicatesSortedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                // Skip the duplicate node
                temp.next = temp.next.next;
            } else {
                // Move to next node
                temp = temp.next;
            }
        }

        return head;
    }
}
