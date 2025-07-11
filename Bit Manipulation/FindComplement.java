// LeetCode #476: Number Complement
// Approach: Use bit manipulation to flip all bits of the number within its binary length

public class FindComplement {
    public int findComplement(int num) {
        // Get the bit length of the number
        int bitCount = Integer.toBinaryString(num).length();

        // Create a mask with all bits set (same length as num)
        int mask = (1 << bitCount) - 1;

        // XOR the number with the mask to flip its bits
        return mask ^ num;
    }
}
