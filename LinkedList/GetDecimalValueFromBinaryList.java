// Problem: Convert Binary Number in a Linked List to Integer (Leetcode #1290)
// Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
// Approach: Traverse list and treat each node as a binary digit shifting left

class GetDecimalValueFromBinaryList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode curr = head;

        // Traverse and shift left each time (binary to decimal conversion)
        while (curr != null) {
            result = (result << 1) | curr.val;
            curr = curr.next;
        }

        return result;
    }
}
