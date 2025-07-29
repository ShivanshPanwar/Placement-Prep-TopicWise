/**
 * LeetCode 1544: Make The String Great
 *
 * Problem:
 * Given a string s, repeatedly remove adjacent characters if they are the same letter
 * but in different cases (e.g., 'a' and 'A'). Continue this process until the string
 * becomes "good" (no such adjacent pairs exist).
 *
 * Approach:
 * - Use a stack to process characters one by one.
 * - For each character:
 *      - If the stack is not empty and the absolute difference between the current character
 *        and the top of the stack is 32 (ASCII difference between uppercase and lowercase),
 *        they are the same letter in different cases, so pop from the stack (remove both).
 *      - Otherwise, push the character onto the stack.
 * - After processing all characters, the stack contains the "good" string in reverse order.
 * - Build the resulting string by popping from the stack and reverse it.
 *
 * Time Complexity: O(n)
 *      - Each character is pushed and popped at most once.
 * Space Complexity: O(n)
 *      - Stack stores up to all characters in the worst case.
 */
class MakeStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if current char and top of stack are the same letter in different cases
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop(); // Remove the pair
            } else {
                stack.push(ch); // Add current character
            }
        }

        // Build the resulting "good" string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString(); // Reverse to restore original order
    }
}
