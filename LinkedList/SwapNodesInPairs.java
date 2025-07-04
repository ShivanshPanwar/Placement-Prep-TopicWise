// Problem: Swap Nodes in Pairs
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/
// Description: Given a linked list, swap every two adjacent nodes and return its head
// Time Complexity: O(n), Space Complexity: O(1)

public class SwapNodesInPairs {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases more easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list in pairs
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Perform swap
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers forward
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
