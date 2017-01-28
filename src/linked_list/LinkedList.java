package linked_list;

/**
 * Created by srinivas on 1/27/17.
 */
public class LinkedList {

    private Node head;

    public void insertAtTop(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }


    // Print the elements of a Node
    @Override
    public String toString() {
        String result = "{";

        Node current =  this.head;
        while(current != null) {
            result += current.toString() + ", ";
            current = current.next;
        }

        result += "}";
        return result;
    }
}
