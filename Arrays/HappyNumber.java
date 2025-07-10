// LeetCode #202: Happy Number
// Approach: Use a HashSet to detect cycles and avoid infinite loops

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>(); // To store numbers we've already seen in the process

        while (true) {
            int sum = 0;

            // Calculate the sum of the squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            if (sum == 1) {
                return true; // If sum becomes 1, it is a happy number
            }

            if (seen.contains(sum)) {
                return false; // A cycle is detected, hence not a happy number
            }

            // Add the sum to the set and repeat with this new number
            seen.add(sum);
            n = sum;
        }
    }
}
