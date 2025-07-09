// LeetCode #155: Min Stack
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

import java.util.Stack;

class MinStack {
    // Stack to hold all values
    Stack<Integer> mainStack;
    
    // Stack to hold the minimum value at each level
    Stack<Integer> minStack;

    // Constructor to initialize the stacks
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int val) {
        mainStack.push(val);

        // If minStack is empty or val is smaller or equal to current min, push it
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            // Else, push the same top again to maintain stack size alignment
            minStack.push(minStack.peek());
        }
    }

    // Removes the element on top of the stack
    public void pop() {
        if (!mainStack.isEmpty() && !minStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        return -1; // Return -1 if stack is empty
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1; // Return -1 if stack is empty
    }
}
