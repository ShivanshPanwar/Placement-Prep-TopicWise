// Problem: Odd Even Linked List (Leetcode #328)
// Link: https://leetcode.com/problems/odd-even-linked-list/
// Approach: Rewire odd and even nodes separately and merge
// Time Complexity: O(n), Space Complexity: O(1)

class OddEvenLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save the start of even list

        // Separate odd and even indexed nodes
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // Connect end of odd list to head of even list
        odd.next = evenHead;
        return head;
    }
}
