/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class RotateList {

    /**
     * Rotates the linked list to the right by k places.
     *
     * Approach:
     * 1. Find the length of the linked list.
     * 2. Connect the tail to the head to make it circular.
     * 3. Bound k within the length of the list using k % size.
     * 4. Move (size - k) steps to find the new tail.
     * 5. Break the circular link to form the rotated list.
     *
     * Time Complexity: O(n) - One pass to find the size and one pass to find the new head.
     * Space Complexity: O(1) - In-place rotation without extra data structures.
     *
     * @param head The head of the linked list.
     * @param k    Number of positions to rotate.
     * @return     The new head of the rotated linked list.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list
        ListNode temp = head;
        int size = 1; // start at 1 since we're already at head
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Make the list circular
        temp.next = head;

        // Step 3: Bound k within list length
        k %= size;
        int stepsToNewHead = size - k;

        // Step 4: Find the new tail
        ListNode newTail = temp;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle to get the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
