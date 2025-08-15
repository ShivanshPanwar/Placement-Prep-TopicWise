/**
 * Approach: Floyd's Tortoise and Hare (Cycle Detection)
 *
 * Problem:
 * Given an array `nums` containing n + 1 integers where each integer is between 1 and n (inclusive),
 * there is exactly one repeated number. The array may be treated as a linked list where
 * nums[i] points to nums[nums[i]], and the duplicate number is the entry point of the cycle.
 *
 * Steps:
 * 1. Use Floyd's cycle detection to find the intersection point of slow and fast pointers.
 * 2. Reset one pointer to the start and move both one step at a time to find the duplicate number.
 *
 * Time Complexity: O(n) - We traverse the array at most twice.
 * Space Complexity: O(1) - No extra space used apart from variables.
 */

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        // Step 1: Detect cycle using slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];           // Move 1 step
            fast = nums[nums[fast]];     // Move 2 steps
        } while (slow != fast);

        // Step 2: Find the entry point of the cycle (duplicate number)
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow; // Duplicate number found
    }
}
