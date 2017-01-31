package linked_list;

/**
 * Created by srinivas on 1/30/17.
 *
 * Reverse the given linked list
 * Input: 50, 40, 30, 20, 10
 * Output: 10, 20, 30, 40, 50
 */
public class ReverseALinkedList {

    private static Node reverseLinkedList(Node head) {

        Node prev = head;
        Node cur = prev.next;
        Node fwd = cur.next;

        while(cur.next != null) {
            // we set the current node's next pointer to the previous node
            cur.next = prev;
            // make previous node point where current node was pointing
            prev = cur;
            // make current node point where forward node was pointing
            cur = fwd;
            // make fwd node point where fwd's next was pointing
            fwd = fwd.next;
        }
        // this would set the last element to point to its previous element
        cur.next = prev;
        // head node should be made to point where cur node was pointing
        head.next = null;
        head = cur;

        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);

        Node head = list.getHead();

        list.printData();

        Node data = reverseLinkedList(head);

        while(data != null) {
            System.out.print(data.data + " ");
            data = data.next;
        }

    }
}
