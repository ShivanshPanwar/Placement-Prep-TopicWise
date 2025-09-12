/*
Given a string `num` representing a non-negative integer and an integer `k`, 
remove `k` digits from the number so that the new number is the smallest possible.

Example:
Input: num = "1432219", k = 3
Output: "1219"

Approach:
--------------------------------
1. Use a StringBuilder to simulate a stack.
2. Traverse each digit in `num`:
   - While the last digit in the StringBuilder is greater than the current digit 
     and we still need to remove digits (k > 0), remove the last digit.
   - Append the current digit.
3. If there are still digits left to remove (k > 0), remove them from the end.
4. Remove leading zeros from the final result.
5. If all digits are removed, return "0".

Time Complexity: O(n), where n = length of num  
Space Complexity: O(n) (for the StringBuilder)
*/

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        // Step 1: Build the smallest number using greedy stack-like approach
        for (char digit : num.toCharArray()) {
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > digit) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(digit);
        }

        // Step 2: If still need to remove digits, remove from the end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        // Step 3: Remove leading zeros
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }

        // Step 4: Return final result
        return index == sb.length() ? "0" : sb.substring(index);
    }
}
