import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else { // ch == ')'
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop(); // treat * as (
                } else {
                    return false;
                }
            }
        }

        // Now match remaining '(' with '*' (if star index is after open index)
        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            } else {
                return false;
            }
        }

        return open.isEmpty();
    }
}
