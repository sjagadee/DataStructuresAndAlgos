package linked_list;

/**
 * Created by srinivas on 1/31/17.
 *
 * partition would make two parts based on x,
 *
 * if the numbers in the list are lesser than that of x it would put them on the left side
 * otherwise on the right side
 *
 */
public class PartitionList {

    public static Node partition(Node node, int x) {

        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(node != null) {
            Node next = node.next;
            node.next = null;
            if(node.data < x) {
                if(beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if(afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }

            node = next;
        }

        if(beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtTail(2);
        list.insertAtTail(5);
        list.insertAtTail(4);
        list.insertAtTail(1);
        list.insertAtTail(9);
        list.insertAtTail(6);
        list.insertAtTail(0);
        list.insertAtTail(3);

        list.printData();

        Node node  = list.getHead();

        Node result = partition(node, 4);

        while(result != null) {
            System.out.print(result.getData() + " ");
            result = result.next;
        }

    }

}
