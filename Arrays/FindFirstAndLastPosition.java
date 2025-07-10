/**
 * LeetCode Problem #34: Find First and Last Position of Element in Sorted Array
 *
 * Problem Statement:
 * Given an array of integers sorted in non-decreasing order and a target value,
 * find the starting and ending position of the target value in the array.
 * If the target is not found, return [-1, -1].
 *
 * Approach:
 * Perform two binary searches:
 * - First search for the leftmost (first) occurrence of the target.
 * - Then search for the rightmost (last) occurrence of the target.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};

        // Find the leftmost (first) index of the target
        int left = binarySearch(nums, target, true);

        // Find the rightmost (last) index of the target
        int right = binarySearch(nums, target, false);

        pos[0] = left;
        pos[1] = right;

        return pos;
    }

    /**
     * Helper method to perform binary search.
     * This method is reused to find both leftmost and rightmost indices by toggling the 'searchLeft' flag.
     * 
     * @param nums        The input array
     * @param target      The value to find
     * @param searchLeft  Flag to determine if searching for left or right boundary
     * @return            Index of the target boundary or -1 if not found
     */
    private int binarySearch(int[] nums, int target, boolean searchLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                // Target must be in the right half
                low = mid + 1;
            } else if (nums[mid] > target) {
                // Target must be in the left half
                high = mid - 1;
            } else {
                // Target found, record index and continue search in appropriate direction
                index = mid;
                if (searchLeft) {
                    high = mid - 1; // Move left to find first occurrence
                } else {
                    low = mid + 1;  // Move right to find last occurrence
                }
            }
        }

        return index;
    }
}
