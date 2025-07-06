// Problem: Sort List (Leetcode #148)
// Link: https://leetcode.com/problems/sort-list/
// Approach: Merge Sort on Linked List
// Time Complexity: O(n log n), Space: O(log n) due to recursion

class SortLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        // Base case: empty or single node
        if (head == null || head.next == null) return head;

        // Step 1: Split the list into two halves
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // cut the list

        // Step 2: Recursively sort both halves
        ListNode leftPart = sortList(left);
        ListNode rightPart = sortList(right);

        // Step 3: Merge the sorted halves
        return merge(leftPart, rightPart);
    }

    // Helper to find middle of list
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // for even length correct split
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach the remaining nodes
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}
