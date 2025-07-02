// Problem: Single Number II (each element appears k times except one)
// Link: https://leetcode.com/problems/single-number-ii/
// Description: Find the unique element where all others appear k times (k = 3 here).
// Approach: Count set bits at each position. If count % k != 0, that bit belongs to the unique number.
// Time Complexity: O(32*n) ~ O(n), Space Complexity: O(1)

public class SingleNumberWithKRepeats {
    public int singleNumber(int[] nums) {
        int result = 0;
        int k = 3;  // Can be changed to handle other repetition counts

        // Check each bit position (0 to 31 for 32-bit integers)
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int x : nums) {
                // Count how many numbers have the i-th bit set
                if (((x >> i) & 1) == 1) {
                    count++;
                }
            }

            // If bit is set in the unique number, include it
            if (count % k != 0) {
                result |= (1 << i);  // Set the i-th bit in result
            }
        }

        return result;
    }
}
