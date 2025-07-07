// Problem: Insertion Sort List (Leetcode #147)
// Link: https://leetcode.com/problems/insertion-sort-list/
// Approach: Extract values → sort using insertion sort → write back to list
// Time: O(n^2), Space: O(n)

import java.util.ArrayList;

class InsertionSortList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        // Step 1: Extract node values into list
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        // Step 2: Perform insertion sort on the array list
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        // Step 3: Rewrite sorted values back to linked list
        curr = head;
        int i = 0;
        while (curr != null) {
            curr.val = list.get(i++);
            curr = curr.next;
        }

        return head;
    }
}
