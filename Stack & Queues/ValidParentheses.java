// Problem: Valid Parentheses (LeetCode #20)
// Approach: Use a Stack to match opening and closing brackets

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                // If stack is empty or brackets don’t match
                if (st.isEmpty()) return false;

                char top = st.peek();
                if ((c == ')' && top == '(') ||
                    (c == ']' && top == '[') ||
                    (c == '}' && top == '{')) {
                    st.pop();
                } else {
                    return false; // Mismatched pair
                }
            }
        }

        // Stack should be empty if all brackets matched
        return st.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isValid("()[]{}"));  // true
        System.out.println(obj.isValid("(]"));      // false
        System.out.println(obj.isValid("([)]"));    // false
    }
}
