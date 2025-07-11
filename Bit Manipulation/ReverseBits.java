// LeetCode #190: Reverse Bits
// Approach: Bit Manipulation using unsigned right shift

public class ReverseBits {
    // You need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;                   // Extract the last bit
            result = (result << 1) | lastBit;      // Shift result left and add last bit
            n = n >>> 1;                           // Unsigned right shift
        }
        return result;
    }
}
