// LeetCode #371: Sum of Two Integers
// Approach: Bit Manipulation - Use XOR for sum and AND for carry

public class GetSumWithoutPlusOperator {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Carry is AND shifted left
            int carry = (a & b) << 1;
            // Sum is XOR
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
