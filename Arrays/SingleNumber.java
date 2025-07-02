// Problem: Single Number
// Link: https://leetcode.com/problems/single-number/
// Description: Every element appears twice except one. Find that element.
// Approach: Use XOR — a ^ a = 0 and a ^ 0 = a
// Time Complexity: O(n), Space Complexity: O(1)

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR all numbers — duplicates cancel out, leaving the unique one
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
