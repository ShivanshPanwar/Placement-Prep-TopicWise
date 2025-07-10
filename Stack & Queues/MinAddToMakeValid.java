// LeetCode Problem 921: Minimum Add to Make Parentheses Valid
// This class uses a Stack to count the number of insertions needed 
// to make the parentheses in the given string valid.

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        // Stack to keep track of unmatched parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the stack is empty, push the current character
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                // If current character is ')' and top of stack is '(', pop the stack (valid pair)
                if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    // Else push the current character (unmatched so far)
                    stack.push(ch);
                }
            }
        }

        // The remaining characters in the stack are unmatched parentheses
        return stack.size();
    }
}
