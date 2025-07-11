// LeetCode #231: Power of Two
// Approach: Use bitwise property - only powers of two have exactly one bit set in binary

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // Edge case: 0 or negative numbers can't be powers of two
        if (n <= 0) {
            return false;
        }

        // A number is a power of two if it has exactly one bit set
        return (n & (n - 1)) == 0;
    }
}
