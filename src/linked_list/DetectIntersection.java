package linked_list;

/**
 * Created by srinivas on 1/30/17.
 */
public class DetectIntersection {

    private static Node detectIntersection(Node node1, Node node2) {
        if(node1 == null || node2 == null) {
            return null;
        }

        Result result1 = getSizeAndTail(node1);
        Result result2 = getSizeAndTail(node2);

        if(result1.tail != result2.tail) {
            return null;
        }

        Node shorter = result1.size < result2.size ? node1 : node2;
        Node longer = result1.size < result2.size ? node2 : node1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    private static  Node getKthNode(Node head, int k) {
        Node current = head;
        while(k>0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    private static Result getSizeAndTail(Node node) {
        if(node == null) {
            return null;
        }
        int size  =1;
        Node tail = node;

        while(tail.next != null){
            size++;
            tail = tail.next;
        }
        return new Result(size, tail);
    }

    public static class Result {
        int size;
        Node tail;
        public Result(int size, Node tail){
            this.size = size;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        list1.insertAtTail(10);
        list1.insertAtTail(20);
        list1.insertAtTail(30);
        list1.insertAtTail(50);
        Node temp = list1.insertAtTail(60);
        list1.insertAtTail(70);
        list1.insertAtTail(80);
        list1.insertAtTail(90);
        list1.insertAtTail(100);
        list1.printData();

        LinkedList list2 = new LinkedList();
        list2.insertAtTail(25);
        list2.insertAtTail(35);
        list2.insertAtTail(45);
        list2.createIntersection(list1, temp, list2);
        list2.printData();

        Node head1 = list1.getHead();
        Node head2 = list2.getHead();

        Node result = detectIntersection(head1, head2);

        System.out.print(result.data);
    }

}
