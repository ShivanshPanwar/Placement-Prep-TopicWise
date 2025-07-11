// LeetCode #191: Number of 1 Bits (Hamming Weight)
// Approach: Use Brian Kernighan’s Algorithm to count the number of set bits

public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;

        // Brian Kernighan’s Algorithm:
        // Each iteration removes the rightmost set bit from n
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
      // return Integer.bitCount(n);  // 2nd Approach
        
    }
}
