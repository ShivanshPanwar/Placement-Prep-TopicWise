// Problem: Linked List Cycle Detection
// Link: https://leetcode.com/problems/linked-list-cycle/
// Description: Detect whether a linked list contains a cycle using Floyd's Tortoise and Hare Algorithm
// Time Complexity: O(n), Space Complexity: O(1)

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        // Edge case: empty list or single node cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 step, fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they ever meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached end, no cycle
        return false;
    }
}
