// Problem: Search in Rotated Sorted Array II (With Duplicates)
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Description: Return true if target exists in a rotated sorted array that may contain duplicates.
// Time Complexity: O(log n) on average, O(n) in worst case due to duplicates.

public class SearchInRotatedSortedArrayWithDuplicates {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found target
            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicate edge case: nums[low] == nums[mid] == nums[high]
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Target in left half
                } else {
                    low = mid + 1;  // Target in right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Target in right half
                } else {
                    high = mid - 1; // Target in left half
                }
            }
        }

        return false; // Target not found
    }
}
