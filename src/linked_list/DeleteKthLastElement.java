package linked_list;

/**
 * Created by srinivas on 1/30/17.
 *
 * Delete the kth last element from the given linked list
 *
 * input list = 10, 20, 30, 40, 50
 * k = 4
 * output list = 10, 30, 40, 50
 *
 */
public class DeleteKthLastElement {

    private static LinkedList list = new LinkedList();

    // deletes the kth last element
    private static void deleteKthLastElement(Node head, int k) {
        // compute the length of the list
        int length = list.getLength();
        // calculate the element to delete by using the formula (length - k)
        // this formula gives us the prior element to the should delete element
        int elementToDelete = length - k;
        int count  = 1;
        Node temp = head;

        // traverse the list till the prior element
        while(count < elementToDelete) {
            temp = temp.next;
            count++;
        }
        // delete the element by pointing the next pointer of the
        // prior element to the next element of the should delete element
        if(temp.next.next != null) {
            temp.next = temp.next.next;
        }
        // this would take care is the last element is to be deleted
        if(temp.next.next == null) {
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        list.insertAtTop(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtTail(60);
        list.insertAtTail(70);

        Node head = list.getHead();

        list.printData();
        // if k = 5, data 30 should be deleted
        deleteKthLastElement(head, 5);

        list.printData();
    }

}
