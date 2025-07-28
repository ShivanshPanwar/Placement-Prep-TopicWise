/**
 * LeetCode 622: Design Circular Queue
 *
 * Implementation of a circular queue using an array.
 *
 * Approach:
 * - Maintain four variables:
 *   - `front`: index of the current front element.
 *   - `rear`: index where the next element will be inserted.
 *   - `count`: number of elements currently in the queue.
 *   - `size`: capacity of the queue.
 * - `enQueue`: Add an element at `rear`, increment `rear` circularly, and increase `count`.
 * - `deQueue`: Move `front` circularly forward and decrease `count`.
 * - `Front` / `Rear`: Return elements at respective positions or -1 if empty.
 * - `isEmpty` / `isFull`: Check if `count` is 0 or equals `size`.
 *
 * Time Complexity: O(1) for all operations.
 * Space Complexity: O(k) where k is the capacity of the queue.
 */
class MyCircularQueue {
    int front, rear, count, size;
    int[] arr;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        rear = 0;
        count = 0;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % size; // wrap-around increment
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size; // move front forward circularly
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + size) % size]; // handle wrap-around for rear
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}
