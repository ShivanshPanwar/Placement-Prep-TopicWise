// LeetCode #394: Decode String
// Topic: Stack & Queues
// Approach: Use two stacks to decode nested encoded strings.

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();              // Stores repeat counts
        Stack<StringBuilder> stringStack = new Stack<>();       // Stores intermediate results

        StringBuilder currString = new StringBuilder();         // Current building string
        int num = 0;                                            // Current number

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');                    // Building multi-digit numbers
            } 
            else if (ch == '[') {
                countStack.push(num);                           // Push repeat count
                stringStack.push(currString);                   // Push current string
                currString = new StringBuilder();               // Reset for nested content
                num = 0;                                        // Reset repeat counter
            } 
            else if (ch == ']') {
                int repeat = countStack.pop();                  // Get repeat count
                StringBuilder prev = stringStack.pop();         // Get string before brackets
                while (repeat-- > 0) {
                    prev.append(currString);                    // Append current string `repeat` times
                }
                currString = prev;                              // Result becomes new current
            } 
            else {
                currString.append(ch);                          // Append character normally
            }
        }

        return currString.toString();                           // Final decoded string
    }
}
