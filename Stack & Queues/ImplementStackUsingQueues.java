// LeetCode Problem: Implement Stack using Queues
// Implement a last-in-first-out (LIFO) stack using two queues.

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // Two queues to simulate stack behavior
    Queue<Integer> q1;
    Queue<Integer> q2;

    // Constructor to initialize both queues
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        // Step 1: Push the new element into q2
        q2.add(x);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap references of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns it.
    public int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }

    // Get the top element.
    public int top() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
