package linked_list;

/**
 * Created by srinivas on 1/30/17.
 *
 * We need to add two list and return the result
 *
 * lists are inverted (example):
 * 617 = 7 -> 1 -> 6
 * 295 = 5 -> 9 -> 2
 *
 * total should be (912) = 2 -> 1 -> 9
 *
 */
public class SumList {

    public static Node addLists(Node l1, Node l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;
        if(l1 != null) {
            value += l1.data;
        }
        if(l2 != null) {
            value += l2.data;
        }

        result.data = value % 10; // this would give the second element (second digit)

        if(l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();
        l1.insertAtTail(7);
        l1.insertAtTail(1);
        l1.insertAtTail(6);

        l1.printData();

        LinkedList l2 = new LinkedList();
        l2.insertAtTail(8);
        l2.insertAtTail(9);
        l2.insertAtTail(8);
        l2.insertAtTail(1);

        l2.printData();
        Node node1 = l1.getHead();
        Node node2 = l2.getHead();

        Node result = addLists(node1, node2, 0);

        while(result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
