package Activity3;
class SinglyLinkedList {
    private Node head;

    SinglyLinkedList() {
        head = null;
    }

    void add(Item item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    void forEach(java.util.function.Consumer<Item> action) {
        Node current = head;
        while (current != null) {
            action.accept(current.data); // Ensure this references the correct 'data' field
            current = current.next;
        }
    }

    void clear() {
        head = null;
    }
}
