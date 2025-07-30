/**
 * Implementation of a basic HashMap using Separate Chaining in Java.
 * 
 * ✅ Approach:
 * - Uses a fixed-size array of linked lists (buckets[]) to store key-value pairs.
 * - Each array index holds the head of a linked list (Node).
 * - Collisions are handled by chaining nodes at the same index.
 * 
 * 🛠️ Core Operations:
 * - put(key, value): Inserts a new key-value pair or updates an existing one.
 * - get(key): Retrieves the value associated with the given key.
 * - remove(key): Deletes the key-value pair if it exists.
 * 
 * ✅ Hash Function:
 * - key % size determines the index for the bucket.
 */

class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    Node[] buckets;
    int size;

    public MyHashMap() {
        size = 1000;  // Fixed-size array
        buckets = new Node[size];
    }

    // Hash function to compute index
    private int getHashKey(int key) {
        return key % size;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int index = getHashKey(key);

        // No node exists at the index; insert directly
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        // Traverse the linked list to update or insert
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // Update existing key
                return;
            }
            if (curr.next == null) {
                curr.next = new Node(key, value); // Insert at end
                return;
            }
            curr = curr.next;
        }
    }

    // Retrieve value for the given key
    public int get(int key) {
        int index = getHashKey(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1; // Key not found
    }

    // Remove the key-value pair
    public void remove(int key) {
        int index = getHashKey(key);

        // No node exists at index
        if (buckets[index] == null) {
            return;
        }

        // First node matches the key
        Node curr = buckets[index];
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        // Traverse to find and remove matching key
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}
