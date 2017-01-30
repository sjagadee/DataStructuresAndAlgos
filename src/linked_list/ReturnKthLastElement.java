package linked_list;

/**
 * Created by srinivas on 1/30/17.
 *
 * This can be done in 2 ways
 * 1. recursive method
 * 2. iterative method
 */
public class ReturnKthLastElement {

    static class Index {
        public int value = 0;
    }

    public static Node returnKthLastElement(Node head, int k) {
        Index idx = new Index();
        return returnKthLastElement(head, k ,idx);
    }

    public static Node returnKthLastElement(Node head, int k, Index idx) {
        if(head == null) {
            return null;
        }
        Node ret = returnKthLastElement(head.next, k, idx);
        idx.value += 1;
        if(idx.value == k) {
            return head;
        }
        return ret;
    }

    public static Node returnKthLastElementIterative(Node head, int k)  {
        Node fast = head;
        Node slow = head;

        for(int i = 0; i < k; i++) {
            if(fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static  void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtTop(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtTail(60);
        list.insertAtTail(70);

        Node head = list.getHead();

        list.printData();
        // if k = 5, data 30 should be returned
        Node kthElementIterative = returnKthLastElementIterative(head, 5);
        System.out.println("Iterative solution: " + kthElementIterative.data);

        // if k=3, then 50 should be returned
        Node kthElementRecursive = returnKthLastElement(head, 3);
        System.out.println("Recursive solution: " + kthElementRecursive.data);

    }
}
