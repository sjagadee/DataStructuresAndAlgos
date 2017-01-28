package linked_list;

/**
 * Created by srinivas on 1/27/17.
 *
 * Demo class to add and delete linked list
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head;


        // Insert at tail of the list
        list.insertAtTail(23);
        list.insertAtTail(24);
        list.insertAtTail(25);

        // Insert at top of the head
        list.insertAtTop(22);
        list.insertAtTop(21);
        list.insertAtTop(20);

        // List print
        list.printData();

        list.deleteNode(25);

        list.printData();


    }

}
