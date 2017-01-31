package linked_list;

/**
 * Created by srinivas on 1/31/17.
 *
 * To detect rotation is present in the linked list
 *
 * this can be done using  a slow and a fast pointer
 */
public class DetectRotation {

    private static boolean detectRotation(Node head){
        if(head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        Node mid = list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtTail(60);
        list.insertAtTail(70);
        list.insertAtTail(80);
        Node last = list.insertAtTail(90);

        list.printData();

        last.next = mid;

        boolean result = detectRotation(list.getHead());

        System.out.print(result);
    }
}
