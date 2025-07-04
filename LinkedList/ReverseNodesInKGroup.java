// Problem: Reverse Nodes in k-Group
// Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
// Description: Given a linked list, reverse the nodes of a list k at a time and return its modified list.
// Time Complexity: O(n), Space Complexity: O(1)

public class ReverseNodesInKGroup {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Helper method to reverse a sublist
    public ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: Count total nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Total full groups that can be reversed
        int groups = count / k;
        count = 0;
        temp = head;

        // Pointers to manage groups
        ListNode nextNode = head, prev = null;
        ListNode newHead = null;
        int innerCount = 1;

        while (count < groups) {
            ListNode start = nextNode;

            // Move to end of current group
            while (innerCount != k && temp != null) {
                temp = temp.next;
                innerCount++;
            }

            innerCount = 1;
            nextNode = temp.next; // Save the next group start
            temp.next = null;     // Break the current group
            temp = nextNode;      // Move temp to next group

            // Reverse current group and connect
            if (prev == null) {
                newHead = reverse(start); // Set new head for the first group
                prev = start;             // Start will become end after reversal
            } else {
                prev.next = reverse(start); // Connect previous group to current
                prev = start;
            }

            count++;
        }

        // Attach remaining part (if any) as-is
        prev.next = temp;
        return newHead;
    }
}
