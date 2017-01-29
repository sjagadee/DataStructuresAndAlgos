package linked_list;

import java.awt.*;

/**
 * Created by srinivas on 1/28/17.
 *
 * This class has two methods:
 * 1. which will delete an element from middle of the list when the head is given
 * 2. delete the element when just the node is given
 *
 * It should not delete first and last element
 *
 */
public class DeleteMiddle {

    private static LinkedList list = new LinkedList();


    public static void deleteFromMiddle(Node head) {

        if(head == null) {
            return;
        } else if (head.next == null) {
            return;
        }
        int length = list.getLength();
        int middle = length/2;
        int count = 0;
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            count++;
            if(temp == head && count == middle) {
                // We are not deleting first element and last element
            } else if (count == middle) {
                prev.next = temp.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
    }

    // This method would simply remove the node is given
    public static void deleteMid(Node node) {
        if(node == null || node.next == null) {
            return;
        }
        // creating a next pointer point to the next of the given node
        Node next = node.next;

        // given node data and next pointer is updated with the next node data and next pointer
        // this step would remove the given node
        node.data = next.data;
        node.next = next.next;
    }

    public static void main(String[] args) {
        Node head = null;
        list.insertAtTail(11);
        list.insertAtTail(13);
        list.insertAtTail(14);
        list.insertAtTail(73);
        list.insertAtTail(19);

        list.printData();
        head = list.getHead();
        System.out.println("With head");
        deleteFromMiddle(head);
        list.printData();

        Node mid = head.next.next;
        System.out.println("Without head");
        deleteMid(mid);

        list.printData();


    }
}
