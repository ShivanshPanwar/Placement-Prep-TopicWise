// Problem: Merge K Sorted Lists
// Link: https://leetcode.com/problems/merge-k-sorted-lists/
// Description: Merge K sorted linked lists into one sorted list.
// Time Complexity: O(N log K), Space Complexity: O(log K) stack space

public class MergeKSortedLists {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    // Divide and Conquer Merge Sort
    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    // Standard merge of two sorted linked lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach any remaining elements
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
