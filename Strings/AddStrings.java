// Problem: Add Strings
// Link: https://leetcode.com/problems/add-strings/
// Description: Add two non-negative integers represented as strings, without converting to integers directly.
// Approach: Simulate addition from right to left using carry, like manual addition.
// Time Complexity: O(n), Space Complexity: O(n)

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // Add digits from both strings until one finishes
        while (i >= 0 && j >= 0) {
            int digit1 = num1.charAt(i--) - '0';
            int digit2 = num2.charAt(j--) - '0';
            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        // If num1 has remaining digits
        while (i >= 0) {
            int sum = (num1.charAt(i--) - '0') + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        // If num2 has remaining digits
        while (j >= 0) {
            int sum = (num2.charAt(j--) - '0') + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        // If carry remains after all digits processed
        if (carry != 0) {
            sb.append(carry);
        }

        // Since we added digits from least to most significant, reverse the result
        return sb.reverse().toString();
    }
}
