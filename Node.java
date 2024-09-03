package Activity3;
class Node {
    Item data; // This is the data field you are referencing in the error
    Node next;

    // Constructor to initialize a node with an item
    Node(Item data) {
        this.data = data;
        this.next = null;  // The next pointer is initialized to null
    }
}
