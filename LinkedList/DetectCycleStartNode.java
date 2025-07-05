// Problem: Linked List Cycle II (Detect Start of Cycle)
// Link: https://leetcode.com/problems/linked-list-cycle-ii/
// Description: If a cycle is present in a linked list, return the node where the cycle begins. Else return null.
// Time Complexity: O(n), Space Complexity: O(1)

public class DetectCycleStartNode {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        // Step 1: Detect if a cycle exists using Floyd’s Tortoise and Hare
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        // No cycle found
        if (!isCycle) return null;

        // Step 2: Find the start node of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both meet at the start of the cycle
        return slow;
    }
}
