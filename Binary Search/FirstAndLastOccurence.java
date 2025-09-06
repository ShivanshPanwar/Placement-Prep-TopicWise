/**
 * Solution to find the first and last position of a target element in a sorted array.
 * If the target is not found, returns [-1, -1].
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FirstAndLastOccurence {

    /**
     * Returns the starting and ending position of a given target value in the array.
     * @param nums Sorted integer array
     * @param target Target value to search for
     * @return Array of two integers [firstOccurrence, lastOccurrence]
     */
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);
        return new int[]{first, last};
    }

    /**
     * Finds the first occurrence index of the target in the array.
     * @param nums Sorted integer array
     * @param target Target value to find
     * @return Index of first occurrence or -1 if not found
     */
    private int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                // Move left to find earlier occurrence
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    /**
     * Finds the last occurrence index of the target in the array.
     * @param nums Sorted integer array
     * @param target Target value to find
     * @return Index of last occurrence or -1 if not found
     */
    private int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                // Move right to find later occurrence
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
