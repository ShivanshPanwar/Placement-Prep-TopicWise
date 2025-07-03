// Problem: Search in Rotated Sorted Array
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Description: Given a rotated sorted array, search for a target using modified binary search.
// Time Complexity: O(log n), Space Complexity: O(1)

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Direct match
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Target is in the left half
                } else {
                    low = mid + 1;  // Search in right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Target in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }

        return -1; // Target not found
    }
}
