// Problem: Intersection of Two Linked Lists
// Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
// Time Complexity: O(m + n)
// Space Complexity: O(1)
// Description: Returns the intersection node of two singly linked lists (if exists)

public class IntersectionOfTwoLinkedLists {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // If one list ends, continue from the beginning of the other
        // They will meet at the intersection or at the end (null)
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // Either the intersection node or null
    }
}
