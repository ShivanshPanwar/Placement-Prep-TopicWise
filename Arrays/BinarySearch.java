// Problem: Binary Search (Iterative)
// Link: https://leetcode.com/problems/binary-search/
// Description: Find the index of target in a sorted array using binary search.
// Time Complexity: O(log n), Space Complexity: O(1)

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                start = mid + 1; // Search right half
            } else {
                end = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }
}
