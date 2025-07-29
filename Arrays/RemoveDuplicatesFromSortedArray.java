/**
 * LeetCode 26: Remove Duplicates from Sorted Array
 *
 * Problem:
 * Given a sorted array nums, remove duplicates in-place such that each unique
 * element appears only once. Return the number of unique elements k.
 *
 * The first k elements of nums should contain the final result. The order must
 * remain the same, and extra space allocation is not allowed (O(1) extra memory).
 *
 * Approach:
 * - Use two pointers:
 *      - i iterates through the array.
 *      - k marks the position to place the next unique element.
 * - Initialize k = 1 because the first element is always unique.
 * - For each nums[i]:
 *      - If it's different from nums[i - 1], it's a new unique element.
 *      - Place it at nums[k] and increment k.
 * - Return k as the count of unique elements.
 *
 * Time Complexity: O(n)
 *      - Each element is checked exactly once.
 * Space Complexity: O(1)
 *      - No additional space used.
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // index for the next unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
