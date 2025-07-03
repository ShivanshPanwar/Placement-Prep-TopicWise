// Problem: Search Insert Position
// Link: https://leetcode.com/problems/search-insert-position/
// Description: Return the index if the target is found. If not, return the index where it would be inserted in order.
// Time Complexity: O(log n), Space Complexity: O(1)

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // Standard binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found at index mid
            } else if (target > nums[mid]) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }

        // If target is not found, low will be the correct insert position
        return low;
    }
}
