import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * Approach:
     * - Use a HashSet to store all unique elements from the array.
     * - For each number, check if it's the start of a sequence (i.e., num - 1 is not in the set).
     * - If so, iterate forward (num + 1, num + 2, ...) to find the full consecutive sequence.
     * - Track the maximum sequence length found.
     *
     * Time Complexity: O(n)
     * - Each number is visited at most twice (once in the for-loop, once in while-loop).
     * Space Complexity: O(n)
     * - HashSet stores up to n elements.
     */

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);  // Add all elements to a set for O(1) lookups
        }

        int longest = 0;

        for (int num : set) {
            // Only check the start of sequences
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak); // Update longest streak
            }
        }

        return longest;
    }
}
