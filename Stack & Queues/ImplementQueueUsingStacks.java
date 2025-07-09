// LeetCode Problem: Implement Queue using Stacks
// Implement a first-in-first-out (FIFO) queue using two stacks.

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // Constructor to initialize the first stack
    public MyQueue() {
        stack1 = new Stack<>();
    }

    // Push element x to the back of the queue
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        stack2 = new Stack<>();
        
        // Transfer all elements from stack1 to stack2 to access front
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Pop the front element
        int front = stack2.pop();

        // Restore the elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return front;
    }

    // Get the front element without removing it
    public int peek() {
        stack2 = new Stack<>();
        
        // Transfer all elements to access front
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int front = stack2.peek();

        // Restore elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return front;
    }

    // Returns true if the queue is empty
    public boolean empty() {
        return stack1.isEmpty();
    }
}
