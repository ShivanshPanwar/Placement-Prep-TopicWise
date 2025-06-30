// Problem: Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Description:
//     Given a sorted array `nums` and a target value, return the starting and ending position of the target.
//     If the target is not found, return [-1, -1].
// Approach:
//     Use binary search twice:
//     - Once to find the first (leftmost) occurrence.
//     - Once to find the last (rightmost) occurrence.
// Time Complexity: O(log n) — binary search on sorted array.
// Space Complexity: O(1) — no extra data structures used.

package arrays.binarysearch;

public class SearchRange {
    /**
     * Finds the first and last positions of the target in the sorted array.
     *
     * @param nums   Sorted integer array
     * @param target Value to search for
     * @return Array of two elements: [firstPosition, lastPosition]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = binarySearch(nums, target, true);   // Find leftmost position
        result[1] = binarySearch(nums, target, false);  // Find rightmost position
        return result;
    }

    /**
     * Binary search helper to find target position.
     *
     * @param nums             Sorted input array
     * @param target           Value to search
     * @param searchLeftBound  If true, searches for the leftmost occurrence;
     *                         otherwise, searches for rightmost.
     * @return Index of the target boundary; -1 if not found
     */
    private int binarySearch(int[] nums, int target, boolean searchLeftBound) {
        int low = 0, high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                index = mid;
                if (searchLeftBound) {
                    high = mid - 1;  // move left
                } else {
                    low = mid + 1;   // move right
                }
            }
        }

        return index;
    }
}
