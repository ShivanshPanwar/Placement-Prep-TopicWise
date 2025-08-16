// Approach: 
// 1. A power of four must first be a power of two → only one bit set in its binary form.
//    We check this using (n & (n - 1)) == 0.
// 2. However, not all powers of two are powers of four (e.g., 2, 8, 32).
//    To ensure the single set bit is in an even position, we use (n % 3 == 1).
//    This works because powers of four give remainder 1 when divided by 3.
//
// Example: 
// 4 -> binary 100, passes power-of-two check, and 4 % 3 == 1 → true
// 8 -> binary 1000, passes power-of-two check, but 8 % 3 == 2 → false
//
// Complexity:
// Time Complexity: O(1) → Only bitwise and modulo operations.
// Space Complexity: O(1) → Constant extra space.

class PowerOfFourChecker {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n % 3 == 1);
    }
}
