// Problem: Find the largest "good integer" in a string.
// A "good integer" is a substring of length 3 consisting of the same digit, e.g., "111", "222".
//
// Approach:
// 1. Traverse the string from index 1 to n-2, checking if (i-1, i, i+1) are the same character.
// 2. If found, compare it with the previously stored "largest good integer".
// 3. Use StringBuilder to store the current best candidate.
// 4. At the end, return the largest 3-digit substring found or "" if none exists.
//
// Example:
// Input: "6777133339"
// Substrings: "777", "333"
// Largest good integer = "777"
//
// Complexity:
// Time Complexity: O(n) → Single pass over the string.
// Space Complexity: O(1) → Only a few extra variables used.

class LargestGoodIntegerFinder {
    public String largestGoodInteger(String num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < num.length() - 1; i++) {
            if (num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1)) {
                char curr = num.charAt(i);

                if (sb.length() == 0) {
                    sb.append(curr).append(curr).append(curr);
                } 
                else if (curr > sb.charAt(0)) {
                    sb.setLength(0); // reset
                    sb.append(curr).append(curr).append(curr);
                }
            }
        }
        return sb.toString();
    }
}
