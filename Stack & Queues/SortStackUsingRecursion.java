// Problem: Sort a Stack using Recursion (GFG)
// Link: https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
// Approach: Recursively pop elements, sort remaining stack, and insert each back in sorted order

import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort the given stack using recursion
    public Stack<Integer> sort(Stack<Integer> s) {
        stackHelper(s);
        return s;
    }

    // Helper function to recursively pop all elements
    public void stackHelper(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        stackHelper(s); // Recursively sort remaining stack
        sortStack(top, s); // Insert popped element in sorted order
    }

    // Helper function to insert an element in a sorted stack
    public void sortStack(int top, Stack<Integer> s) {
        if (s.isEmpty() || s.peek() <= top) {
            s.push(top);
            return;
        }

        int temp = s.pop();
        sortStack(top, s); // Keep popping until right spot found
        s.push(temp); // Push the saved elements back
    }

    // Example usage
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        SortStackUsingRecursion obj = new SortStackUsingRecursion();
        obj.sort(stack);

        System.out.println("Sorted Stack: " + stack); // Output: [1, 2, 3, 4]
    }
}
