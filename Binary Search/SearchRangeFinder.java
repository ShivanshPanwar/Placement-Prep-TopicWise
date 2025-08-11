/**
 * Approach:
 * We perform two separate binary searches to find:
 *  1. The leftmost (first) index of the target.
 *  2. The rightmost (last) index of the target.
 * 
 * Steps:
 * - First binary search (`isSearchingLeft = true`) moves towards the left side
 *   even after finding the target, to locate the first occurrence.
 * - Second binary search (`isSearchingLeft = false`) moves towards the right side
 *   to locate the last occurrence.
 * - If the target is not found, both positions remain as -1.
 * 
 * Time Complexity: O(log n)  
 *   - We do two binary searches, each taking O(log n).
 * Space Complexity: O(1)  
 *   - We use only constant extra space.
 */
public class SearchRangeFinder {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};
        pos[0] = binarySearch(nums, target, true);  // Find leftmost index
        pos[1] = binarySearch(nums, target, false); // Find rightmost index
        return pos;
    }

    private static int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
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
                if (isSearchingLeft) {
                    high = mid - 1; // Move left to find first occurrence
                } else {
                    low = mid + 1;  // Move right to find last occurrence
                }
            }
        }
        return index;
    }
}
