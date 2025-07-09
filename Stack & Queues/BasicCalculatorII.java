// LeetCode #227: Basic Calculator II
// Evaluate a simple expression string containing non-negative integers, '+', '-', '*', and '/' operators.

class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        char operator = '+'; // Initialize with '+' to handle the first number

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build the operand - can be multiple digits
            if (Character.isDigit(ch)) {
                operand = operand * 10 + (ch - '0');
            }

            // If current char is an operator or we reached the end of the string
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (operator) {
                    case '+':
                        stack.push(operand);
                        break;
                    case '-':
                        stack.push(-operand);
                        break;
                    case '*':
                        stack.push(stack.pop() * operand);
                        break;
                    case '/':
                        stack.push(stack.pop() / operand);
                        break;
                }
                operator = ch;
                operand = 0;
            }
        }

        // Sum up all the results in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
