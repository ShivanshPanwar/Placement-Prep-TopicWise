/**
 * Problem: LeetCode 7 - Reverse Integer
 * Link: https://leetcode.com/problems/reverse-integer/
 * 
 * Approach:
 * - Extract digits one by one using modulus (%) and build the reversed number.
 * - Multiply the current reversed number by 10 and add the extracted digit.
 * - Before casting to int, ensure the result stays within the 32-bit signed integer range.
 * - If overflow/underflow occurs, return 0.
 * 
 * Time Complexity: O(log₁₀N) — number of digits in x
 * Space Complexity: O(1)
 */

class ReverseInteger {
    public int reverse(int x) {
        int rem;
        long rev = 0;  // Use long to detect overflow during reversal

        while (x != 0) {
            rem = x % 10;            // Get last digit
            rev = rev * 10 + rem;    // Append to reversed number
            x = x / 10;              // Remove last digit

            // Check for 32-bit integer overflow
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) rev;
    }
}
