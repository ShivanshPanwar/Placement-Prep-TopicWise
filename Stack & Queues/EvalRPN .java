import java.util.Stack;

public class EvalRPN {
    /**
     * Evaluates the value of an arithmetic expression in Reverse Polish Notation (RPN).
     * 
     * Approach:
     * - Use a stack to store operands.
     * - Iterate through each token:
     *   - If the token is an operator (+, -, *, /):
     *       1. Pop the top two operands from the stack.
     *       2. Perform the operation in correct order (num2 op num1).
     *       3. Push the result back onto the stack.
     *   - If the token is a number, parse it and push onto the stack.
     * - At the end, the stack will have a single element: the evaluated result.
     * 
     * Time Complexity: O(n), where n is the number of tokens.
     *    - We process each token exactly once.
     * Space Complexity: O(n) in the worst case (when all tokens are numbers).
     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            // Check if current token is an operator
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                // Pop top two numbers from stack
                int num1 = stack.pop();
                int num2 = stack.pop();

                // Compute result and push back onto stack
                int res = findValue(num1, num2, str);
                stack.push(res);
            } else {
                // Token is a number; push it onto the stack
                stack.push(Integer.parseInt(str));
            }
        }

        // Final evaluated result will be the only element in the stack
        return stack.peek();
    }

    /**
     * Helper method to perform arithmetic operation based on the operator.
     * 
     * @param num1 - First operand (popped last from stack)
     * @param num2 - Second operand (popped before num1)
     * @param operator - Arithmetic operator ("+", "-", "*", "/")
     * @return Result of the operation (integer division truncates toward zero for "/")
     */
    public int findValue(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            default: // division
                return num2 / num1;
        }
    }
}
