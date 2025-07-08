// Problem: Reverse a Stack using Recursion (GFG)
// Link: https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
// Approach: Use recursion to reverse the stack by inserting elements at the bottom

import java.util.Stack;

public class ReverseStackUsingRecursion {

    // Function to reverse the stack
    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s); // Reverse the remaining stack
        insertAtBottom(top, s); // Insert the popped item at the bottom
    }

    // Helper function to insert an element at the bottom of the stack
    public static void insertAtBottom(int val, Stack<Integer> st) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insertAtBottom(val, st); // Go to the bottom
        st.push(top); // Push all elements back
    }

    // Example usage
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
