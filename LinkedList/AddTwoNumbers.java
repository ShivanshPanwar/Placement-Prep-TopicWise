// Problem: Add Two Numbers
// Link: https://leetcode.com/problems/add-two-numbers/
// Description: Add two numbers represented by linked lists (in reverse order) and return the sum as a linked list
// Time Complexity: O(max(m, n)), Space Complexity: O(max(m, n)) — where m and n are the lengths of the lists

public class AddTwoNumbers {
    
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to simplify appending nodes
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        // Traverse both lists and handle carry
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // Create a new node for the digit
            tail.next = new ListNode(digit);
            tail = tail.next;

            // Move to next nodes
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummyHead.next;
    }
}
