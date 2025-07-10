// LeetCode #81: Search in Rotated Sorted Array II
// Approach: Modified Binary Search to handle duplicates in a rotated sorted array

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        // Standard binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid element is the target
            if (nums[mid] == target) return true;

            // Handling duplicates: skip over same values from both ends
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // If left part is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target is in the left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    // Otherwise search in right half
                    low = mid + 1;
                }
            }
            // If right part is sorted
            else {
                // Check if target is in the right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    // Otherwise search in left half
                    high = mid - 1;
                }
            }
        }

        // If loop ends, target is not found
        return false;
    }
}
