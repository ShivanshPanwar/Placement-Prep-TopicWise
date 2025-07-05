// Problem: Remove N-th Node From End of List
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Description: Remove the n-th node from the end of a singly linked list.
// Time Complexity: O(n), Space Complexity: O(1)

public class RemoveNthNodeFromEnd {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases like deleting the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow one step until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
