package Activity3;
import java.util.LinkedList;
import javax.swing.JTextArea;
 
// Class representing an item in the shopping cart
class Item {
    String name;
    double price;
 
    // Constructor to initialize the item with a name and a price
    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
 
// Node class for the singly linked list
class Node {
    Item data;
    Node next;
 
    // Constructor to initialize a node with an item
    Node(Item data) {
        this.data = data;
        this.next = null;
    }
}
 
// Singly linked list implementation for the shopping cart
class SinglyLinkedList {
    private Node head;
 
    // Constructor to initialize the list
    SinglyLinkedList() {
        head = null;
    }
 
    // Method to add an item to the list
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
 
    // Method to check if the list is empty
    boolean isEmpty() {
        return head == null;
    }
 
    // Method to iterate over the list and perform an action
    void forEach(java.util.function.Consumer<Item> action) {
        Node current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }
 
    // Method to clear the list
    void clear() {
        head = null;
    }
}
 
// Class representing the shopping cart
class ShoppingCart {
    SinglyLinkedList cart;
 
    // Constructor to initialize the shopping cart
    ShoppingCart() {
        cart = new SinglyLinkedList();
    }
 
    // Method to add an item to the cart based on its name
    void addItem(String name) {
        double price = autoPrice(name); // Get the price of the item based on its name
        if (price == 0) {
            System.out.println("No item found for: " + name); // No item found
        } else {
            cart.add(new Item(name, price)); // Add the item to the cart
            System.out.println(name + " added to the cart with price ₱" + price);
        }
    }
 
    // Method to automatically determine the price of an item based on its name
    double autoPrice(String name) {
        switch (name.toLowerCase()) {
            case "refrigerator":
                return 25000.00;
            case "cpu":
                return 20000.00;
            case "tv":
                return 20000.00;
            case "laptop":
                return 20000.00;
            case "microwave":
                return 5000.00;
            case "cellphone":
                return 10000.00;
            case "aircon":
                return 25000.00;
            default:
                return 0; // Return 0 to indicate that the item is not found
        }
    }
 
    // Method to display items in the cart in a JTextArea
    void displayItemsInTextArea(JTextArea textArea) {
        if (cart.isEmpty()) {
            textArea.append("Your cart is empty.\n");
            return;
        }
 
        textArea.append("Items in your cart:\n");
        cart.forEach(item -> textArea.append(item.name + ": ₱" + item.price + "\n"));
    }
 
    // Method to perform checkout and display the total in a JTextArea
    void checkoutInTextArea(JTextArea textArea) {
        if (cart.isEmpty()) {
            textArea.append("Your cart is empty.\n");
            return;
        }
 
        double[] total = {0};
        textArea.append("Items in your cart:\n");
        cart.forEach(item -> {
            textArea.append(item.name + ": ₱" + item.price + "\n");
            total[0] += item.price;
        });
        textArea.append("Total: ₱" + total[0] + "\n");
         
        cart.clear(); // Clear the cart after checkout
        textArea.append("Thank you for your purchase! Your cart is now empty.\n");
    }
}